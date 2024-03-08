package luis122448;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    private FizzBuzz fizzBuzz;
    @BeforeEach
    public void setup() {
        this.fizzBuzz = new FizzBuzz();
    }
    @Test
    public void return_fizz_when_number_is_divisible_by_3() {
        assertEquals("Fizz", fizzBuzz.fizzBuzz(3));
        assertEquals("Fizz", fizzBuzz.fizzBuzz(6));
        assertEquals("Fizz", fizzBuzz.fizzBuzz(9));
    }
    @Test
    public void return_buzz_when_number_is_divisible_by_5() {
        assertEquals("Buzz", fizzBuzz.fizzBuzz(5));
        assertEquals("Buzz", fizzBuzz.fizzBuzz(10));
        assertEquals("Buzz", fizzBuzz.fizzBuzz(20));
    }
    @Test
    public void return_fizzbuzz_when_number_is_divisible_by_3_and_5() {
        assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(15));
        assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(30));
        assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(45));
    }
    @Test
    public void return_number_when_number_is_not_divisible_by_3_or_5() {
        assertEquals("1", fizzBuzz.fizzBuzz(1));
        assertEquals("2", fizzBuzz.fizzBuzz(2));
        assertEquals("4", fizzBuzz.fizzBuzz(4));
    }

}