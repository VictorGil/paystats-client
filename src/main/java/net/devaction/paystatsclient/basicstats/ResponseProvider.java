package net.devaction.paystatsclient.basicstats;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.devaction.paystatsclient.basicstats.model.Response;
import net.devaction.util.PropertiesProvider;

/**
 * @author Víctor Gil
 */
public class ResponseProvider{
private static final Log log = LogFactory.getLog(ResponseProvider.class);
    
    private static final String BASE_URL = "https://apis.bbva.com/paystats_sbx/4";
    private static final PropertiesProvider propertiesProvider = PropertiesProvider.getInstance();
    
    public static Response provide(String suffixUrl, int year){
        String url = BASE_URL + suffixUrl;
        log.debug("URL: " + url);        
        Client client = ClientBuilder.newClient();
        
        String minDate = Integer.toString(year) + "01";
        String maxDate = Integer.toString(year) + "12";
        WebTarget webTarget = client.target(url).queryParam("min_date", minDate).queryParam("max_date", maxDate)
                .queryParam("channel", "pos").queryParam("cards", "all");
        
        Invocation.Builder invocationBuilder = webTarget.request(APPLICATION_JSON);
        //we use "access token" and "authorization token" interchangeably
        final String authorizationToken = propertiesProvider.get("access_token");
        log.debug("Authorization token: " + authorizationToken);
        Invocation invocation = invocationBuilder.header("Authorization", "jwt " + authorizationToken).buildGet();
        Response response = invocation.invoke(Response.class);
        log.debug("Response from the server:\n" + response);
        return response;
    }
}
