package luis122448.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {

    @Test
    public void total_zero_when_there_are_prices() {
        PriceCalculator priceCalculator = new PriceCalculator();
        assertEquals(0.0, priceCalculator.getTotal());
    }
    @Test
    public void total_is_the_sum_of_prices() {
        PriceCalculator priceCalculator = new PriceCalculator();
        priceCalculator.addPrice(10.2);
        priceCalculator.addPrice(15.5);
        assertEquals(25.7, priceCalculator.getTotal());
    }
    @Test
    public void total_is_zero_when_prices_are_null() {
        PriceCalculator priceCalculator = new PriceCalculator();
        priceCalculator.addPrice(null);
        assertEquals(0.0, priceCalculator.getTotal());
    }
    @Test
    public void apply_discount_to_prices() {
        PriceCalculator priceCalculator = new PriceCalculator();
        priceCalculator.addPrice(60.0);
        priceCalculator.addPrice(40.0);
        priceCalculator.addDiscount(25.0);
        assertEquals(75.0, priceCalculator.getTotal());
    }
}