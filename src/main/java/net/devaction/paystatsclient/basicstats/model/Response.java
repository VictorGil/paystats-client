package net.devaction.paystatsclient.basicstats.model;

import java.util.List;

/**
 * @author Víctor Gil
 */
public class Response{
    private Result result;
    private List<Data> data;
    
    @Override
    public String toString() {
        return "Response [result=" + result + ", data=" + data + "]";
    }
    
    public Result getResult() {
        return result;
    }
    public void setResult(Result result) {
        this.result = result;
    }
    public List<Data> getData() {
        return data;
    }
    public void setData(List<Data> data) {
        this.data = data;
    }
}
