package net.devaction.paystatsclient.basicstats.tiles;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import net.devaction.paystatsclient.basicstats.ResponseProvider;
import net.devaction.paystatsclient.basicstats.model.Response;
import net.devaction.paystatsclient.basicstats.tiles.model.Tile;

/**
 * @author Víctor Gil
 */
public class TileResponseProvider{
    private static final Log log = LogFactory.getLog(ResponseProvider.class);
    private static final String SUFFIX_URL = "/tiles/%1$s/%2$s/basic_stats";    
    
    public static Response provide(Tile tile, int year){
        String suffixUrl = String.format(SUFFIX_URL, tile.getLatitudeString(), tile.getLongitudeString());
        log.debug("Suffix URL: " + suffixUrl);
        return ResponseProvider.provide(suffixUrl, year);        
    }    
}
