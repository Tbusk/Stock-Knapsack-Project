package edu.ferris.seng355;

import edu.ferris.seng355.csv.RandomStockCSVBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class CreateCSVTest {

    @Test
    void testCreateStocksCSV() throws IOException {
        RandomStockCSVBuilder csvBuilder = new RandomStockCSVBuilder();
        csvBuilder.buildCsv(10);
        csvBuilder.buildCsv(25);
        csvBuilder.buildCsv(50);
        csvBuilder.buildCsv(100);
        csvBuilder.buildCsv(250);
        csvBuilder.buildCsv(500);
        csvBuilder.buildCsv(750);
        csvBuilder.buildCsv(1_000);
        csvBuilder.buildCsv(5_000);
        csvBuilder.buildCsv(10_000);
        csvBuilder.buildCsv(15_000);
        csvBuilder.buildCsv(25_000);
    }
}
