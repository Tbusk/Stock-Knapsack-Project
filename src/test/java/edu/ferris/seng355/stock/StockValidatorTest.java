package edu.ferris.seng355.stock;

import edu.ferris.seng355.general_exceptions.TypeException;
import edu.ferris.seng355.stock.validators.NewPriceValidator;
import edu.ferris.seng355.stock.validators.StockPriceValidator;
import edu.ferris.seng355.stock.validators.StockPriceIncreaseProbabilityValidator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StockValidatorTest {

    @Nested
    class StockPriceValidatorTest {

        private final StockPriceValidator validator = new StockPriceValidator();

        @Test
        void validate_too_small_stock_price_returns_false () throws TypeException {

            assertFalse(validator.validate(new Stock("", Integer.MIN_VALUE, 1, 1)));
            assertFalse(validator.validate(new Stock("", -1_000_000_000, 1, 1)));
            assertFalse(validator.validate(new Stock("", -1, 1, 1)));
            assertFalse(validator.validate(new Stock("", -0.01, 1, 1)));
            assertFalse(validator.validate(new Stock("", 0.99, 1, 1)));
            assertFalse(validator.validate(new Stock("", 0, 1, 1)));

        }

        @Test
        void validate_valid_stock_price_returns_true () throws TypeException {

            assertTrue(validator.validate(new Stock("", 1, 1, 1)));
            assertTrue(validator.validate(new Stock("", 10, 1, 1)));
            assertTrue(validator.validate(new Stock("", 50, 1, 1)));
            assertTrue(validator.validate(new Stock("", 99.99, 1, 1)));
            assertTrue(validator.validate(new Stock("", 100, 1, 1)));

        }

        @Test
        void validate_too_large_stock_price_returns_false () throws TypeException {

            assertFalse(validator.validate(new Stock("", Integer.MAX_VALUE, 1, 1)));
            assertFalse(validator.validate(new Stock("", 1_000_000_000, 1, 1)));
            assertFalse(validator.validate(new Stock("", 100.01, 1, 1)));
            assertFalse(validator.validate(new Stock("", 101, 1, 1)));
            assertFalse(validator.validate(new Stock("", 10_000, 1, 1)));

        }

        @Test
        void incorrect_type_throws_type_exception(){
            record TestRecordOne(String test) {}
            record TestRecordTwo(double test) {}

            assertThrows(TypeException.class, () -> validator.validate(new TestRecordOne("")));
            assertThrows(TypeException.class, () -> validator.validate(new TestRecordTwo(0)));
        }

    }

    @Nested
    class NewPriceValidatorTest {

        private final NewPriceValidator validator = new NewPriceValidator();

        @Test
        void validate_too_small_new_stock_price_returns_false () throws TypeException {

            assertFalse(validator.validate(new Stock("", 1, 1, Integer.MIN_VALUE)));
            assertFalse(validator.validate(new Stock("", 1, 1, -1_000_000_000)));
            assertFalse(validator.validate(new Stock("", 1, 1, -1)));
            assertFalse(validator.validate(new Stock("", 1, 1, -0.01)));
            assertFalse(validator.validate(new Stock("", 1, 1, 0)));
            assertFalse(validator.validate(new Stock("", 1, 1, 0.99)));

        }

        @Test
        void validate_valid_new_stock_price_returns_true () throws TypeException {

            assertTrue(validator.validate(new Stock("", 1, 1, 1)));
            assertTrue(validator.validate(new Stock("", 1, 1, 1.01)));
            assertTrue(validator.validate(new Stock("", 1, 1, 10)));
            assertTrue(validator.validate(new Stock("", 1, 1, 50)));
            assertTrue(validator.validate(new Stock("", 1, 1, 100)));
            assertTrue(validator.validate(new Stock("", 1, 1, 150)));
            assertTrue(validator.validate(new Stock("", 1, 1, 199.99)));
            assertTrue(validator.validate(new Stock("", 1, 1, 200)));

        }

        @Test
        void validate_too_large_new_stock_price_returns_false () throws TypeException {

            assertFalse(validator.validate(new Stock("", 1, 1, 200.01)));
            assertFalse(validator.validate(new Stock("", 1, 1, 201)));
            assertFalse(validator.validate(new Stock("", 1, 1, 250)));
            assertFalse(validator.validate(new Stock("", 1, 1, 1_000)));
            assertFalse(validator.validate(new Stock("", 1, 1, 1_000_000_000)));
            assertFalse(validator.validate(new Stock("", 1, 1, Integer.MAX_VALUE)));

        }

        @Test
        void incorrect_type_throws_type_exception(){
            record TestRecordOne(String test) {}
            record TestRecordTwo(double test) {}

            assertThrows(TypeException.class, () -> validator.validate(new TestRecordOne("")));
            assertThrows(TypeException.class, () -> validator.validate(new TestRecordTwo(0)));
        }
    }

    @Nested
    class StockPriceIncreaseProbabilityValidatorTest {

        private final StockPriceIncreaseProbabilityValidator validator = new StockPriceIncreaseProbabilityValidator();

        @Test
        void validate_too_small_stock_price_probability_returns_false () throws TypeException {

            assertFalse(validator.validate(new Stock("", 1, Integer.MIN_VALUE, 1)));
            assertFalse(validator.validate(new Stock("", 1, -1_000_000_000, 1)));
            assertFalse(validator.validate(new Stock("", 1, -1_000, 1)));
            assertFalse(validator.validate(new Stock("", 1, -10, 1)));
            assertFalse(validator.validate(new Stock("", 1, -1, 1)));
            assertFalse(validator.validate(new Stock("", 1, -0.01, 1)));

        }

        @Test
        void validate_valid_stock_price_probability_returns_true () throws TypeException {

            assertTrue(validator.validate(new Stock("", 1, 0, 1)));
            assertTrue(validator.validate(new Stock("", 1, 0.000001, 1)));
            assertTrue(validator.validate(new Stock("", 1, 0.2, 1)));
            assertTrue(validator.validate(new Stock("", 1, 0.5, 1)));
            assertTrue(validator.validate(new Stock("", 1, 0.6, 1)));
            assertTrue(validator.validate(new Stock("", 1, 0.8, 1)));
            assertTrue(validator.validate(new Stock("", 1, 0.99, 1)));
            assertTrue(validator.validate(new Stock("", 1, 1, 1)));

        }

        @Test
        void validate_too_large_stock_price_probability_returns_false () throws TypeException {

            assertFalse(validator.validate(new Stock("", 1, 1.000001, 1)));
            assertFalse(validator.validate(new Stock("", 1, 10, 1)));
            assertFalse(validator.validate(new Stock("", 1, 1_000, 1)));
            assertFalse(validator.validate(new Stock("", 1, 1_000_000_000, 1)));
            assertFalse(validator.validate(new Stock("", 1, Integer.MAX_VALUE, 1)));

        }

        @Test
        void incorrect_type_throws_type_exception(){
            record TestRecordOne(String test) {}
            record TestRecordTwo(double test) {}

            assertThrows(TypeException.class, () -> validator.validate(new TestRecordOne("")));
            assertThrows(TypeException.class, () -> validator.validate(new TestRecordTwo(0)));
        }

    }


}
