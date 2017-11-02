package net.devaction.paystatsclient.basicstats.zipcodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.devaction.paystatsclient.basicstats.model.Response;
import net.devaction.paystatsclient.basicstats.zipcodes.model.MaxAmountItem;

/**
 * @author Víctor Gil
 */
public class MaxAmountListProvider{

    public static List<MaxAmountItem> provide(int year){
        List<MaxAmountItem> list = new ArrayList<MaxAmountItem>();
        
        ZipCodesProvider zipCodeprovider = new ZipCodesProvider();
        String zipCode;
        while ((zipCode = zipCodeprovider.provide()) != null) {
            Response response = ZipCodeResponseProvider.provide(zipCode, year);
            MaxAmountItem maxAmountItem = MaxAmountInZipCodeProvider.provide(response, zipCode);
            list.add(maxAmountItem);            
        }
        list.sort(Collections.reverseOrder());
        return list;
    }
}
