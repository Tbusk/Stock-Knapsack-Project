package edu.ferris.seng355.csv;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import edu.ferris.seng355.items.Stock;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class StockDataImporter {

    public List<Stock> getStocksWithWeightsAndValuesFromCSV(String fileNameWithPath) throws IOException {
        List<Stock> stocks = getStocksFromCSV(fileNameWithPath);

        stocks.forEach(stock -> {
            double value = (stock.getPossibleNewPrice() - stock.getPrice()) * stock.getPriceIncreaseProbability();
            stock.setValue(value);
            stock.setWeight(stock.getPrice());
        });

        return stocks;
    }

    public List<Stock> getStocksFromCSV(String fileNameWithPath) throws IOException {
        File csvFile = new File(fileNameWithPath);

        return new CsvMapper()
                .readerFor(Stock.class)
                .with(buildCsvSchema())
                .<Stock>readValues(csvFile)
                .readAll();
    }

    private CsvSchema buildCsvSchema() {
        return CsvSchema.builder()
                .setSkipFirstDataRow(true)
                .addColumn("price")
                .addColumn("possibleNewPrice")
                .addColumn("priceIncreaseProbability")
                .setColumnSeparator(',')
                .build();
    }
}
