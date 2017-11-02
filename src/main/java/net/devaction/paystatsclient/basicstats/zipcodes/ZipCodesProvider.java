package net.devaction.paystatsclient.basicstats.zipcodes;

/**
 * @author Víctor Gil
 */
public class ZipCodesProvider{
    private int zipCode = FIRST;
    private static final int FIRST = 28000;
    private static final int LAST = 28999;
    
    /* 
     * This method is stateful and thread-unsafe
     * */
    public String provide(){
        if (zipCode <= LAST) {
            String zipCodeToBeReturned = Integer.toString(zipCode);
            zipCode++;
            return zipCodeToBeReturned;
        }            
        return null;        
    }
}
