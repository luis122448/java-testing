package luis122448.utils;


import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

    private List<Double> prices;
    private double discount;
    public PriceCalculator() {
        this.prices = new ArrayList<>();
        this.discount = 0.0;
    }
    public double getTotal() {
        if(this.prices.isEmpty()) {
            return 0.0;
        }
        double result = 0.0;
        for (Double price : prices) {
            if (price != null) {
                result += price;
            }
        }
        return result * ((100.0-discount)/100.0);
    }
    public void addPrice(Double v) {
        if (v == null) {
            throw new IllegalArgumentException("Price can't be null");
        }
        prices.add(v);
    }

    public void addDiscount(double i) {
        discount = i;
    }
}
