package net.devaction.paystatsclient.basicstats.tiles;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.devaction.paystatsclient.basicstats.model.Response;
import net.devaction.paystatsclient.basicstats.tiles.model.MaxAmountItem;
import net.devaction.paystatsclient.basicstats.tiles.model.Tile;

/**
 * @author Víctor Gil
 */
public class MaxAmountListProvider{

    public static List<MaxAmountItem> provide(int year, BigDecimal minLatitude, 
            BigDecimal minLongitude, BigDecimal maxLatitude, BigDecimal maxLongitude){
        List<MaxAmountItem> list = new ArrayList<MaxAmountItem>();
        
        TilesProvider tilesProvider = new TilesProvider(minLatitude, minLongitude, maxLatitude, maxLongitude);
        Tile tile;
        while ((tile = tilesProvider.provide()) != null) {
            Response response = TileResponseProvider.provide(tile, year);
            MaxAmountItem maxAmountItem = MaxAmountInTileProvider.provide(response, tile);
            list.add(maxAmountItem);            
        }
        list.sort(Collections.reverseOrder());
        return list;
    }
    
    public static List<MaxAmountItem> provide(int year, String minLatitude, 
            String minLongitude, String maxLatitude, String maxLongitude){
        return provide(year, new BigDecimal(minLatitude), new BigDecimal(minLongitude), 
                new BigDecimal(maxLatitude), new BigDecimal(maxLongitude));
    }
}
