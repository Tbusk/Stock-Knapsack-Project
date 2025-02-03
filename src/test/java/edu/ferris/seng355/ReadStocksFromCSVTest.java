package edu.ferris.seng355;

import edu.ferris.seng355.csv.StockDataImporter;
import edu.ferris.seng355.items.Stock;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReadStocksFromCSVTest {

    @Test
    void testReadingStocksFromCSV() throws IOException {
        StockDataImporter dataImporter = new StockDataImporter();

        List<Stock> stocks = dataImporter.getStocksFromCSV("stock_data/10-stocks-data.csv");
        assertEquals(10, stocks.size());

        assertEquals(14.42, stocks.getFirst().getPrice());
        assertEquals(67.87, stocks.getLast().getPrice());
        assertEquals(31.86, stocks.getFirst().getPossibleNewPrice());
        assertEquals(141.59, stocks.getLast().getPossibleNewPrice());
        assertEquals(0.35442, stocks.getFirst().getPriceIncreaseProbability());
        assertEquals(0.102394, stocks.getLast().getPriceIncreaseProbability());

        stocks = dataImporter.getStocksFromCSV("stock_data/25-stocks-data.csv");
        assertEquals(25, stocks.size());

        assertEquals(5.13, stocks.getFirst().getPrice());
        assertEquals(64.5, stocks.getLast().getPrice());
        assertEquals(133.56, stocks.getFirst().getPossibleNewPrice());
        assertEquals(151.6, stocks.getLast().getPossibleNewPrice());
        assertEquals(0.076454, stocks.getFirst().getPriceIncreaseProbability());
        assertEquals(0.233773, stocks.getLast().getPriceIncreaseProbability());

        stocks = dataImporter.getStocksFromCSV("stock_data/50-stocks-data.csv");
        assertEquals(50, stocks.size());

        assertEquals(69.9, stocks.getFirst().getPrice());
        assertEquals(93.42, stocks.getLast().getPrice());
        assertEquals(199.36, stocks.getFirst().getPossibleNewPrice());
        assertEquals(64.09, stocks.getLast().getPossibleNewPrice());
        assertEquals(0.132578, stocks.getFirst().getPriceIncreaseProbability());
        assertEquals(0.453711, stocks.getLast().getPriceIncreaseProbability());
    }
}
