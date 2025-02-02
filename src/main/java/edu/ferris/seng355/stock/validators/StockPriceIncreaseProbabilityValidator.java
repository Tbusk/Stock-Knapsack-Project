package edu.ferris.seng355.stock.validators;

import edu.ferris.seng355.general_exceptions.TypeException;
import edu.ferris.seng355.stock.Stock;
import edu.ferris.seng355.stock.StockConstants;
import edu.ferris.seng355.validator.Validator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StockPriceIncreaseProbabilityValidator implements Validator {
    @Override
    public boolean validate(Record record) throws TypeException {

        if(!(record instanceof Stock stock)) {

            String currentClassName = record.getClass().getTypeName();
            String expectedClassName = Stock.class.getTypeName();

            throw new TypeException(expectedClassName, currentClassName);
        }

        BigDecimal probability = BigDecimal.valueOf(stock.priceIncreaseProbability()).setScale(6, RoundingMode.HALF_UP);

        boolean isProbabilityAboveOrAtMinimum = probability.compareTo(StockConstants.MINIMUM_STOCK_INCREASE_PROBABILITY) >= 0;
        boolean isProbabilityBelowOrAtMaximum = probability.compareTo(StockConstants.MAXIMUM_STOCK_INCREASE_PROBABILITY) <= 0;

        return isProbabilityAboveOrAtMinimum && isProbabilityBelowOrAtMaximum;

    }
}
