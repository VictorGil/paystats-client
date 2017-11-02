package net.devaction.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Víctor Gil
 */
public class PropertiesProvider{
    private static final Log log = LogFactory.getLog(PropertiesProvider.class);
    
    private static PropertiesProvider INSTANCE;
    private Properties appProperties;
    
    public static PropertiesProvider getInstance(){
        if (INSTANCE == null)
            INSTANCE = new PropertiesProvider();
        return INSTANCE;
    }
    
    private PropertiesProvider(){
        String propFileName = "application.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        appProperties = new Properties();
        try{
            appProperties.load(inputStream);
        }catch(IOException ex){
            log.fatal(ex, ex);
            throw new RuntimeException(ex);
        }finally{
            if (inputStream != null){
                try{
                    inputStream.close();
                } catch(IOException ex){
                    log.error(ex, ex);
                }
            }
        }
    }
    
    public String get(String propertyName){
        return appProperties.getProperty(propertyName);
    }
    
}
