package net.devaction.paystatsclient.basicstats.tiles.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author Víctor Gil
 */
public class Tile{
    public static final DecimalFormat FORMAT = new DecimalFormat("###0.000");
    private BigDecimal latitude;
    private BigDecimal longitude;
    
    public Tile(BigDecimal latitude, BigDecimal longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    @Override
    public String toString() {
        return "Tile [latitude=" + getLatitudeString() + ", longitude=" + getLongitudeString() + "]";
    }
    
    public BigDecimal getLatitude(){
        return latitude;
    }
    public BigDecimal getLongitude(){
        return longitude;
    }
    public String getLatitudeString(){
        return FORMAT.format(latitude);
    }
    public String getLongitudeString(){
        return FORMAT.format(longitude);
    } 
}
