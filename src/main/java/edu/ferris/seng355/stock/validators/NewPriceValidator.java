package edu.ferris.seng355.stock.validators;

import edu.ferris.seng355.general_exceptions.TypeException;
import edu.ferris.seng355.stock.Stock;
import edu.ferris.seng355.stock.StockConstants;
import edu.ferris.seng355.validator.Validator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NewPriceValidator implements Validator {

    @Override
    public boolean validate(Record record) throws TypeException {

        if(!(record instanceof Stock stock)) {

            String currentClassName = record.getClass().getTypeName();
            String expectedClassName = Stock.class.getTypeName();

            throw new TypeException(expectedClassName, currentClassName);
        }

        BigDecimal possibleNewPrice = BigDecimal.valueOf(stock.possibleNewPrice()).setScale(2, RoundingMode.HALF_UP);

        boolean isNewPriceAboveOrAtMinimum = possibleNewPrice.compareTo(StockConstants.MINIMUM_NEW_STOCK_PRICE) >= 0;
        boolean isNewPriceBelowOrAtMaximum = possibleNewPrice.compareTo(StockConstants.MAXIMUM_NEW_STOCK_PRICE) <= 0;

        return isNewPriceAboveOrAtMinimum && isNewPriceBelowOrAtMaximum;
    }
}
