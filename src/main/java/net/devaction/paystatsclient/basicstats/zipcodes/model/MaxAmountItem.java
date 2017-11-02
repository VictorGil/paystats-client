package net.devaction.paystatsclient.basicstats.zipcodes.model;

import java.math.BigDecimal;

/**
 * @author Víctor Gil
 */
public class MaxAmountItem implements Comparable<MaxAmountItem>{

    private String zipCode;
    private BigDecimal maxAmount;
    private String month;
    
    private static final int GREATER = 1;
    private static final int EQUAL = 0;
    private static final int LESS = -1;
    
    @Override
    public String toString() {
        return "MaxAmountItem [zipCode=" + zipCode + ", maxAmount=" + maxAmount + ", month=" + month + "]";
    }
    
    public MaxAmountItem(String zipCode, BigDecimal maxAmount, String month){
        this.maxAmount = maxAmount;
        this.zipCode = zipCode;
        this.month = month;
    }
    
    public MaxAmountItem(String zipCode){
        this.zipCode = zipCode;
    }    
    
    public int compareTo(MaxAmountItem other) {
        if (other == null)
            return GREATER;
        if (other.maxAmount == null){
            if (maxAmount == null)
                return EQUAL;
            return GREATER;
        }        
        if (maxAmount == null)
            return LESS;
        return maxAmount.compareTo(other.maxAmount);
    }
    
    //getters
    public BigDecimal getMaxAmount() {
        return maxAmount;
    }
    public String getZipCode() {
        return zipCode;
    }
    public String getMonth() {
        return month;
    }
}
