package edu.ferris.seng355.csv;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import edu.ferris.seng355.items.Stock;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RandomStockCSVBuilder {

    public static String DESTINATION_FOLDER = "stock_data";

    public void buildCsv(int numberOfStocks) throws IOException {

        byte[] csvByteData = getCsvByteData(numberOfStocks);

        Files.write(getCsvFilePath(numberOfStocks), csvByteData);
    }

    private byte[] getCsvByteData(int numberOfStocks) throws JsonProcessingException {
        List<Stock> stocks = generateRandomStockData(numberOfStocks);
        
        return new CsvMapper()
                .writer(buildCsvSchemaForStock())
                .writeValueAsBytes(stocks);
    }

    public CsvSchema buildCsvSchemaForStock() {
        return CsvSchema.builder()
                .addColumn("price")
                .addColumn("possibleNewPrice")
                .addColumn("priceIncreaseProbability")
                .build()
                .withHeader();
    }

    public List<Stock> generateRandomStockData(int numberOfStocks) {
        List<Stock> stocks = new ArrayList<>();

        for(int i = 0; i < numberOfStocks; i++) {
            stocks.add(createRandomStock());
        }

        return stocks;
    }

    public Stock createRandomStock() {
        return new Stock(
                getRandomStockStartValue(),
                getRandomStockIncreasePercentage(),
                getRandomNewPossiblePrice()
        );
    }

    private Path getCsvFilePath(int numberOfStocks) {
        return Path.of(buildCSVFileName(numberOfStocks));
    }
    
    public String buildCSVFileName(int numberOfStocks) {
        return String.format("%s/%d-stocks-data.csv", DESTINATION_FOLDER, numberOfStocks);
    }

    // Stock price can be between $1 and $100
    public double getRandomStockStartValue() {
        return round((Math.random() * 100), 2);
    }

    // Stock price increase probability can be between 0 and 1
    public double getRandomStockIncreasePercentage() {
        return round(Math.random(), 6);
    }

    // Stock new possible price can be between $1 and $200.
    public double getRandomNewPossiblePrice() {
        return round(Math.random() * 200, 2);
    }

    public double round(double value, int numberOfPlaces) {
        return BigDecimal.valueOf(value).setScale(numberOfPlaces, RoundingMode.HALF_UP).doubleValue();
    }

}
