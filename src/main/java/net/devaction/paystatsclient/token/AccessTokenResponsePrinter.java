package net.devaction.paystatsclient.token;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.Base64;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.devaction.paystatsclient.token.AccessTokenResponse;
import net.devaction.util.PropertiesProvider;

/**
 * @author Víctor Gil
 *
 */
public class AccessTokenResponsePrinter{
    private static final Log log = LogFactory.getLog(AccessTokenResponsePrinter.class);
	
    private static final String GET_ACCESS_TOKEN_URL = "https://connect.bbva.com/token?grant_type=client_credentials";
    private static final String APP_ID = PropertiesProvider.getInstance().get("appId");
    private static final String OAUTH_SECRET = PropertiesProvider.getInstance().get("oAuthSecret");
    private static String ENCODED_CREDENTIALS;

    private Client client = ClientBuilder.newClient();
	
    public static void main(String[] args){
        if (APP_ID == null || APP_ID.length() == 0){
            String errMessage = "App id null or empty, set a valid app id in application.properties file. Exiting";
            log.fatal(errMessage);
            System.err.println("ERROR: " + errMessage);
            return;
        }
        if (OAUTH_SECRET == null || OAUTH_SECRET.length() == 0){
            String errMessage = "OAUTH secret code null or empty, set a valid OAUTH secret code in application.properties file. Exiting";
            log.fatal(errMessage);
            System.err.println("ERROR: " + errMessage);
            return;
        }            
            
        ENCODED_CREDENTIALS = getEncodedCredentials(APP_ID, OAUTH_SECRET);
        new AccessTokenResponsePrinter().run();
    }
    
    void run(){
        log.info("URL to get the access/authorization token: " + GET_ACCESS_TOKEN_URL);
        WebTarget webTarget = client.target(GET_ACCESS_TOKEN_URL);
        Invocation.Builder invocationBuilder = webTarget.request(APPLICATION_JSON); //this sets the header "Content-Type; application/json"
        Invocation invocation = invocationBuilder.header("Authorization", "Basic " + ENCODED_CREDENTIALS).buildPost(null);
        //String response = invocation.invoke(String.class);
        AccessTokenResponse response = invocation.invoke(AccessTokenResponse.class);
        log.info("Response from the server:\n" + response);        
    }
    
    static String getEncodedCredentials(String appId, String oAuthSecret){
        String credentials = appId + ":" + oAuthSecret;
        log.info("Credentials to be encoded: " + credentials);
        byte[] encodedBytes = Base64.getEncoder().encode(credentials.getBytes());
        String encodedCredentials = new String(encodedBytes);
        log.info("Encoded credentials: " + encodedCredentials);
        
        return encodedCredentials;
    }
}
