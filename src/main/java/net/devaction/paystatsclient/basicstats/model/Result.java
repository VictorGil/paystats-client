package net.devaction.paystatsclient.basicstats.model;

/**
 * @author Víctor Gil
 */
public class Result{
    private int code;
    private String info;
    
    @Override
    public String toString() {
        return "Result [code=" + code + ", info=" + info + "]";
    }
    
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
}
