package Oefenopdracht5;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Btw {

    private double btw;
    private double prijs;

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public double getBtw() {
        return btw;
    }

    public void setBtw(double btw) {
        this.btw = btw;
    }

    public String getPrijsInclusiefBtw(){
        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(prijs * (1 + btw/100));
    }

}
