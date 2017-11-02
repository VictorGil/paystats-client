package net.devaction.paystatsclient.basicstats.zipcodes;

import java.math.BigDecimal;
import static java.math.BigDecimal.ZERO;
import java.util.List;

import net.devaction.paystatsclient.basicstats.model.Data;
import net.devaction.paystatsclient.basicstats.model.Response;
import net.devaction.paystatsclient.basicstats.zipcodes.model.MaxAmountItem;

/**
 * @author Víctor Gil
 */
public class MaxAmountInZipCodeProvider{
private static final int IS_LESS = -1;

    public static MaxAmountItem provide(Response response, String zipCode){
        if (response == null || response.getData() == null || response.getData().isEmpty())
            return new MaxAmountItem(zipCode);        
        
        List<Data> dataList = response.getData();
        BigDecimal maxAmount = ZERO;
        BigDecimal amount;
        String month = null;
        for (Data data : dataList){
            amount = BigDecimal.valueOf(data.getMax());
            if (maxAmount.compareTo(amount) == IS_LESS) {
                maxAmount = amount;
                month = data.getDate();
            }
        }
        return new MaxAmountItem(zipCode, maxAmount, month);
    }
}
