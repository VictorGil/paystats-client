package net.devaction.paystatsclient.basicstats.tiles.model;

import static net.devaction.paystatsclient.basicstats.tiles.model.Tile.FORMAT;

import java.math.BigDecimal;
/**
 * @author Víctor Gil
 */
public class MaxAmountItem implements Comparable<MaxAmountItem>{

    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal maxAmount;
    private String month;
    
    private static final int GREATER = 1;
    private static final int EQUAL = 0;
    private static final int LESS = -1;
    
    @Override
    public String toString() {
        return "MaxAmountItem [latitude=" + FORMAT.format(latitude) + ", longitude=" + FORMAT.format(longitude) + ", maxAmount=" + maxAmount
                + ", month=" + month + "]";
    }
    
    public MaxAmountItem(Tile tile, BigDecimal maxAmount, String month){
        this.latitude = tile.getLatitude();
        this.longitude = tile.getLongitude();
        this.maxAmount = maxAmount;
        this.month = month;
    }
    
    public MaxAmountItem(Tile tile){
        this.latitude = tile.getLatitude();
        this.longitude = tile.getLongitude();
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
    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }
}
