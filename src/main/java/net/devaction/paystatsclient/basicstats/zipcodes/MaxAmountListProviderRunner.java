package net.devaction.paystatsclient.basicstats.zipcodes;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.devaction.paystatsclient.basicstats.zipcodes.model.MaxAmountItem;
import net.devaction.util.Converter;

/**
 * @author Víctor Gil
 */
public class MaxAmountListProviderRunner{
    private static final Log log = LogFactory.getLog(MaxAmountListProviderRunner.class);
    
    public static void main(String args[]){
        int year = Integer.parseInt(args[0]);
        log.info("Going to get the list of the highest transaction amounts"
                + " for each month in Madrid during the year " + year);
        List<MaxAmountItem> list = MaxAmountListProvider.provide(year);
        log.info("The ordered list:\n" + Converter.toNiceString(list));
    }
}
