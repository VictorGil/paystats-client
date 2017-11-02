package net.devaction.paystatsclient.basicstats.model;

/**
 * @author Víctor Gil
 */
public class Data{
    private String date;
    private double avg;
    private double max;
    private double min;
    private double std;
    private int peak_txs_day;
    private int valley_txs_day;
    private int peak_txs_hour;
    private int valley_txs_hour;
    private int merchants;
    private int cards;
    private int txs;
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(avg);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + cards;
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        temp = Double.doubleToLongBits(max);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + merchants;
        temp = Double.doubleToLongBits(min);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + peak_txs_day;
        result = prime * result + peak_txs_hour;
        temp = Double.doubleToLongBits(std);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + txs;
        result = prime * result + valley_txs_day;
        result = prime * result + valley_txs_hour;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Data other = (Data) obj;
        if (Double.doubleToLongBits(avg) != Double.doubleToLongBits(other.avg))
            return false;
        if (cards != other.cards)
            return false;
        if (date == null){
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (Double.doubleToLongBits(max) != Double.doubleToLongBits(other.max))
            return false;
        if (merchants != other.merchants)
            return false;
        if (Double.doubleToLongBits(min) != Double.doubleToLongBits(other.min))
            return false;
        if (peak_txs_day != other.peak_txs_day)
            return false;
        if (peak_txs_hour != other.peak_txs_hour)
            return false;
        if (Double.doubleToLongBits(std) != Double.doubleToLongBits(other.std))
            return false;
        if (txs != other.txs)
            return false;
        if (valley_txs_day != other.valley_txs_day)
            return false;
        if (valley_txs_hour != other.valley_txs_hour)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Data [date=" + date + ", avg=" + avg + ", max=" + max + ", min=" + min + ", std=" + std
                + ", peak_txs_day=" + peak_txs_day + ", valley_txs_day=" + valley_txs_day + ", peak_txs_hour="
                + peak_txs_hour + ", valley_txs_hour=" + valley_txs_hour + ", merchants=" + merchants + ", cards="
                + cards + ", txs=" + txs + "]";
    }
    
    //getters and setters
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public double getAvg() {
        return avg;
    }
    public void setAvg(double avg) {
        this.avg = avg;
    }
    public double getMax() {
        return max;
    }
    public void setMax(double max) {
        this.max = max;
    }
    public double getMin() {
        return min;
    }
    public void setMin(double min) {
        this.min = min;
    }
    public double getStd() {
        return std;
    }
    public void setStd(double std) {
        this.std = std;
    }
    public int getPeak_txs_day() {
        return peak_txs_day;
    }
    public void setPeak_txs_day(int peak_txs_day) {
        this.peak_txs_day = peak_txs_day;
    }
    public int getValley_txs_day() {
        return valley_txs_day;
    }
    public void setValley_txs_day(int valley_txs_day) {
        this.valley_txs_day = valley_txs_day;
    }
    public int getPeak_txs_hour() {
        return peak_txs_hour;
    }
    public void setPeak_txs_hour(int peak_txs_hour) {
        this.peak_txs_hour = peak_txs_hour;
    }
    public int getValley_txs_hour() {
        return valley_txs_hour;
    }
    public void setValley_txs_hour(int valley_txs_hour) {
        this.valley_txs_hour = valley_txs_hour;
    }
    public int getMerchants() {
        return merchants;
    }
    public void setMerchants(int merchants) {
        this.merchants = merchants;
    }
    public int getCards() {
        return cards;
    }
    public void setCards(int cards) {
        this.cards = cards;
    }
    public int getTxs() {
        return txs;
    }
    public void setTxs(int txs) {
        this.txs = txs;
    }    
}
