package net.devaction.paystatsclient.basicstats.zipcodes;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.devaction.paystatsclient.basicstats.ResponseProvider;
import net.devaction.paystatsclient.basicstats.model.Response;

/**
 * @author Víctor Gil
 */
public class ZipCodeResponseProvider{
    private static final Log log = LogFactory.getLog(ZipCodeResponseProvider.class);
    private static final String SUFFIX_URL = "/zipcodes/%1$s/basic_stats";
    
    public static Response provide(String zipCode, int year){
        String suffixUrl = String.format(SUFFIX_URL, zipCode);
        log.debug("Suffix URL: " + suffixUrl); 
        return ResponseProvider.provide(suffixUrl, year);
    }
    
    public static Response provide(int zipCode, int year){
        return provide(Integer.toString(zipCode), year);
    }
}
