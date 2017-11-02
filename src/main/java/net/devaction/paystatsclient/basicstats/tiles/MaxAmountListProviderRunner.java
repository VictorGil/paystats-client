package net.devaction.paystatsclient.basicstats.tiles;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.devaction.paystatsclient.basicstats.tiles.model.MaxAmountItem;
import net.devaction.util.Converter;
import net.devaction.util.PropertiesProvider;

/**
 * @author Víctor Gil
 */
public class MaxAmountListProviderRunner{
    private static final Log log = LogFactory.getLog(MaxAmountListProviderRunner.class);
    private static final PropertiesProvider propertiesProvider = PropertiesProvider.getInstance();
    
    public static void main(String args[]){
        int year = Integer.parseInt(args[0]);
        
        String minLatitude = propertiesProvider.get("minLatitude");
        String minLongitude = propertiesProvider.get("minLongitude");
        String maxLatitude = propertiesProvider.get("maxLatitude");
        String maxLongitude = propertiesProvider.get("maxLongitude");
        
        log.info("Going to get the list of the highest transaction amounts"
                + " for each month in Madrid during the year " + year);
        List<MaxAmountItem> list = MaxAmountListProvider.provide(year, minLatitude, 
                minLongitude, maxLatitude, maxLongitude);
        log.info("The ordered list:\n" + Converter.toNiceString(list));
    }
}
