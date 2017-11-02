package net.devaction.paystatsclient.basicstats.tiles;

import java.math.BigDecimal;

import net.devaction.paystatsclient.basicstats.tiles.model.Tile;

/**
 * @author Víctor Gil
 */
public class TilesProvider{
    private BigDecimal latitude;
    private BigDecimal longitude;
    
    private BigDecimal minLongitude;
    private BigDecimal maxLatitude;
    private BigDecimal maxLongitude;
    
    private static final BigDecimal INCREMENT = BigDecimal.valueOf(0.005d);
    
    private static final int GREATER = 1;
    private static final int LESS = -1;
    private static final int EQUAL = 0;
    
    public TilesProvider(BigDecimal minLatitude, BigDecimal minLongitude, 
            BigDecimal  maxLatitude, BigDecimal maxLongitude){
        checkParameters(minLatitude, minLongitude, maxLatitude, maxLongitude);
        
        this.minLongitude = minLongitude;
        this.maxLatitude = maxLatitude;
        this.maxLongitude = maxLongitude;
        
        latitude = minLatitude;
        longitude = minLongitude;
    }
    /* 
     * This method is stateful and thread-unsafe
     * */
    public Tile provide(){
        if (longitude.compareTo(maxLongitude) == LESS){
            Tile tile = new Tile(latitude, longitude);
            longitude = longitude.add(INCREMENT);
            return tile;
        }
        if (latitude.compareTo(maxLatitude) == LESS || latitude.compareTo(maxLatitude) == EQUAL){
            Tile tile = new Tile(latitude, longitude);
            latitude = latitude.add(INCREMENT);
            longitude = minLongitude;
            return tile;
        }        
        return null;        
    }
    
   private void checkParameters(BigDecimal minLatitude, BigDecimal minLongitude, 
            BigDecimal  maxLatitude, BigDecimal maxLongitude){
       if (minLatitude.compareTo(maxLatitude) > GREATER)           
           throw new IllegalArgumentException("Minimal latitude cannot be greater than the maximun latitude");
       if (minLongitude.compareTo(maxLongitude) > GREATER)
           throw new IllegalArgumentException("Minimal longitude cannot be greater than the maximun longitude");
   }
}
