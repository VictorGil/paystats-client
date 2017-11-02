package net.devaction.paystatsclient;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.devaction.paystatsclient.token.AccessTokenResponsePrinter;
import net.devaction.util.PropertiesProvider;

/**
 * @author Víctor Gil
 */
public class PayStatsTester{
    private static final Log log = LogFactory.getLog(AccessTokenResponsePrinter.class);
    
    private static final String BASE_URL = "https://apis.bbva.com/paystats_sbx/4";
    private final Client client = ClientBuilder.newClient();
    private final PropertiesProvider propertiesProvider = PropertiesProvider.getInstance();
    
    public static void main(String[] args){
        new PayStatsTester().run();
    }
    
    void run(){
        String zipCode = "28001";
        //String zipCode = "28981";
        //String zipCode = "28980";
        //String zipCode = "46001"; //it throws: Exception in thread "main" javax.ws.rs.ForbiddenException: HTTP 403 Forbidden
        String url = BASE_URL + "/zipcodes/%1$s/basic_stats";
        url = String.format(url, zipCode);
        log.debug("URL: " + url);
        WebTarget webTarget = client.target(url).queryParam("min_date", "201501").queryParam("max_date", "201512")
                .queryParam("channel", "pos").queryParam("cards", "all");
        
        Invocation.Builder invocationBuilder = webTarget.request(APPLICATION_JSON); 
        final String authorizationToken = propertiesProvider.get("authorizationToken");
        log.debug("Authorization token: " + authorizationToken);
        Invocation invocation = invocationBuilder.header("Authorization", "jwt " + authorizationToken).buildGet();
        String response = invocation.invoke(String.class);
        log.info("Response from the server:\n" + response);        
    }
}
