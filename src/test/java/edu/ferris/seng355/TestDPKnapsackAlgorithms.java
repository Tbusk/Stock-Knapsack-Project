package edu.ferris.seng355;

import edu.ferris.seng355.algorithms.DPKnapsackAlgorithm;
import edu.ferris.seng355.csv.StockDataImporter;
import edu.ferris.seng355.items.Stock;
import edu.ferris.seng355.knapsack.Knapsack;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class TestDPKnapsackAlgorithms {

    StockDataImporter stockDataImporter;
    DPKnapsackAlgorithm dpKnapsackAlgorithm;

    TestDPKnapsackAlgorithms() {
        stockDataImporter = new StockDataImporter();
        dpKnapsackAlgorithm = new DPKnapsackAlgorithm();
    }

    @Test
    void testDPKnapsackAlgorithmWithTenStock() throws IOException {
        double budget = 2_500;
        List<Stock> availableStock = stockDataImporter.getStocksWithWeightsAndValuesFromCSV("stock_data/10-stocks-data.csv");

        Timer timer = new Timer();
        timer.start();
        Knapsack knapsack = dpKnapsackAlgorithm.collect(availableStock, budget);
        timer.end();
        knapsack.getItems().forEach(System.out::println);

        double totalValue = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(stock -> ((stock.getPossibleNewPrice() - stock.getPrice()) * stock.getPriceIncreaseProbability())).sum();
        double totalWeight = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(Stock::getPrice).sum();

        System.out.printf("Total Profit Potential: $%,.2f, Total Weight: %f, Time Taken: %dms\n", totalValue, totalWeight, timer.getDurationInMS());
    }

    @Test
    void testDPKnapsackAlgorithmWithTwentyFiveStock() throws IOException {
        double budget = 2_500;
        List<Stock> availableStock = stockDataImporter.getStocksWithWeightsAndValuesFromCSV("stock_data/25-stocks-data.csv");

        Timer timer = new Timer();
        timer.start();
        Knapsack knapsack = dpKnapsackAlgorithm.collect(availableStock, budget);
        timer.end();
        knapsack.getItems().forEach(System.out::println);

        double totalValue = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(stock -> ((stock.getPossibleNewPrice() - stock.getPrice()) * stock.getPriceIncreaseProbability())).sum();
        double totalWeight = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(Stock::getPrice).sum();

        System.out.printf("Total Profit Potential: $%,.2f, Total Weight: %f, Time Taken: %dms\n", totalValue, totalWeight, timer.getDurationInMS());
    }

    @Test
    void testDPKnapsackAlgorithmWithFiftyStock() throws IOException {
        double budget = 2_500;
        List<Stock> availableStock = stockDataImporter.getStocksWithWeightsAndValuesFromCSV("stock_data/50-stocks-data.csv");

        Timer timer = new Timer();
        timer.start();
        Knapsack knapsack = dpKnapsackAlgorithm.collect(availableStock, budget);
        timer.end();
        knapsack.getItems().forEach(System.out::println);

        double totalValue = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(stock -> ((stock.getPossibleNewPrice() - stock.getPrice()) * stock.getPriceIncreaseProbability())).sum();
        double totalWeight = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(Stock::getPrice).sum();

        System.out.printf("Total Profit Potential: $%,.2f, Total Weight: %f, Time Taken: %dms\n", totalValue, totalWeight, timer.getDurationInMS());
    }

    @Test
    void testDPKnapsackAlgorithmWithOneHundredStock() throws IOException {
        double budget = 2_500;
        List<Stock> availableStock = stockDataImporter.getStocksWithWeightsAndValuesFromCSV("stock_data/100-stocks-data.csv");

        Timer timer = new Timer();
        timer.start();
        Knapsack knapsack = dpKnapsackAlgorithm.collect(availableStock, budget);
        timer.end();
        knapsack.getItems().forEach(System.out::println);

        double totalValue = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(stock -> ((stock.getPossibleNewPrice() - stock.getPrice()) * stock.getPriceIncreaseProbability())).sum();
        double totalWeight = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(Stock::getPrice).sum();

        System.out.printf("Total Profit Potential: $%,.2f, Total Weight: %f, Time Taken: %dms\n", totalValue, totalWeight, timer.getDurationInMS());
    }

    @Test
    void testDPKnapsackAlgorithmWithTwoHundredFiftyStock() throws IOException {
        double budget = 2_500;
        List<Stock> availableStock = stockDataImporter.getStocksWithWeightsAndValuesFromCSV("stock_data/250-stocks-data.csv");

        Timer timer = new Timer();
        timer.start();
        Knapsack knapsack = dpKnapsackAlgorithm.collect(availableStock, budget);
        timer.end();
        knapsack.getItems().forEach(System.out::println);

        double totalValue = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(stock -> ((stock.getPossibleNewPrice() - stock.getPrice()) * stock.getPriceIncreaseProbability())).sum();
        double totalWeight = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(Stock::getPrice).sum();

        System.out.printf("Total Profit Potential: $%,.2f, Total Weight: %f, Time Taken: %dms\n", totalValue, totalWeight, timer.getDurationInMS());
    }

    @Test
    void testDPKnapsackAlgorithmWithFiveHundredStock() throws IOException {
        double budget = 2_500;
        List<Stock> availableStock = stockDataImporter.getStocksWithWeightsAndValuesFromCSV("stock_data/500-stocks-data.csv");

        Timer timer = new Timer();
        timer.start();
        Knapsack knapsack = dpKnapsackAlgorithm.collect(availableStock, budget);
        timer.end();
        knapsack.getItems().forEach(System.out::println);

        double totalValue = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(stock -> ((stock.getPossibleNewPrice() - stock.getPrice()) * stock.getPriceIncreaseProbability())).sum();
        double totalWeight = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(Stock::getPrice).sum();

        System.out.printf("Total Profit Potential: $%,.2f, Total Weight: %f, Time Taken: %dms\n", totalValue, totalWeight, timer.getDurationInMS());
    }

    @Test
    void testDPKnapsackAlgorithmWithOneThousandStock() throws IOException {
        double budget = 2_500;
        List<Stock> availableStock = stockDataImporter.getStocksWithWeightsAndValuesFromCSV("stock_data/1000-stocks-data.csv");

        Timer timer = new Timer();
        timer.start();
        Knapsack knapsack = dpKnapsackAlgorithm.collect(availableStock, budget);
        timer.end();
        knapsack.getItems().forEach(System.out::println);

        double totalValue = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(stock -> ((stock.getPossibleNewPrice() - stock.getPrice()) * stock.getPriceIncreaseProbability())).sum();
        double totalWeight = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(Stock::getPrice).sum();

        System.out.printf("Total Profit Potential: $%,.2f, Total Weight: %f, Time Taken: %dms\n", totalValue, totalWeight, timer.getDurationInMS());
    }

    @Test
    void testDPKnapsackAlgorithmWithFiveThousandStock() throws IOException {
        double budget = 2_500;
        List<Stock> availableStock = stockDataImporter.getStocksWithWeightsAndValuesFromCSV("stock_data/5000-stocks-data.csv");

        Timer timer = new Timer();
        timer.start();
        Knapsack knapsack = dpKnapsackAlgorithm.collect(availableStock, budget);
        timer.end();
        knapsack.getItems().forEach(System.out::println);

        double totalValue = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(stock -> ((stock.getPossibleNewPrice() - stock.getPrice()) * stock.getPriceIncreaseProbability())).sum();
        double totalWeight = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(Stock::getPrice).sum();

        System.out.printf("Total Profit Potential: $%,.2f, Total Weight: %f, Time Taken: %dms\n", totalValue, totalWeight, timer.getDurationInMS());
    }

    @Test
    void testDPKnapsackAlgorithmWithTenThousandStock() throws IOException {
        double budget = 2_500;
        List<Stock> availableStock = stockDataImporter.getStocksWithWeightsAndValuesFromCSV("stock_data/10000-stocks-data.csv");

        Timer timer = new Timer();
        timer.start();
        Knapsack knapsack = dpKnapsackAlgorithm.collect(availableStock, budget);
        timer.end();
        knapsack.getItems().forEach(System.out::println);

        double totalValue = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(stock -> ((stock.getPossibleNewPrice() - stock.getPrice()) * stock.getPriceIncreaseProbability())).sum();
        double totalWeight = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(Stock::getPrice).sum();

        System.out.printf("Total Profit Potential: $%,.2f, Total Weight: %f, Time Taken: %dms\n", totalValue, totalWeight, timer.getDurationInMS());
    }

    @Test
    void testDPKnapsackAlgorithmWithFifteenThousandStock() throws IOException {
        double budget = 2_500;
        List<Stock> availableStock = stockDataImporter.getStocksWithWeightsAndValuesFromCSV("stock_data/15000-stocks-data.csv");

        Timer timer = new Timer();
        timer.start();
        Knapsack knapsack = dpKnapsackAlgorithm.collect(availableStock, budget);
        timer.end();

        knapsack.getItems().forEach(System.out::println);

        double totalValue = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(stock -> ((stock.getPossibleNewPrice() - stock.getPrice()) * stock.getPriceIncreaseProbability())).sum();
        double totalWeight = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(Stock::getPrice).sum();

        System.out.printf("Total Profit Potential: $%,.2f, Total Weight: %f, Time Taken: %dms\n", totalValue, totalWeight, timer.getDurationInMS());
    }
}
