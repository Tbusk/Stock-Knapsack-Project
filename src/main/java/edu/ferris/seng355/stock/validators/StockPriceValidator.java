package edu.ferris.seng355.stock.validators;

import edu.ferris.seng355.general_exceptions.TypeException;
import edu.ferris.seng355.stock.Stock;
import edu.ferris.seng355.stock.StockConstants;
import edu.ferris.seng355.validator.Validator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StockPriceValidator implements Validator {

    @Override
    public boolean validate(Record record) throws TypeException {

        if(!(record instanceof Stock stock)) {

            String currentClassName = record.getClass().getTypeName();
            String expectedClassName = Stock.class.getTypeName();

            throw new TypeException(expectedClassName, currentClassName);
        }

        BigDecimal price = BigDecimal.valueOf(stock.price()).setScale(2, RoundingMode.HALF_UP);

        boolean isPriceAboveOrAtMinimum = price.compareTo(StockConstants.MINIMUM_STOCK_PRICE) >= 0;
        boolean isPriceBelowOrAtMaximum = price.compareTo(StockConstants.MAXIMUM_STOCK_PRICE) <= 0;

        return isPriceAboveOrAtMinimum && isPriceBelowOrAtMaximum;
    }

}
