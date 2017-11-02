package net.devaction.paystatsclient.model.zipcodesbasicstats;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.devaction.paystatsclient.basicstats.model.Response;
import net.devaction.paystatsclient.basicstats.zipcodes.ZipCodeResponseProvider;

/**
 * @author Víctor Gil
 */
public class DataProviderTester{
    private static final Log log = LogFactory.getLog(DataProviderTester.class);
    
    public static void main(String[] args){
        String zipCode = "28980";
        
        Response response = ZipCodeResponseProvider.provide(zipCode, 2015);
    }
}
