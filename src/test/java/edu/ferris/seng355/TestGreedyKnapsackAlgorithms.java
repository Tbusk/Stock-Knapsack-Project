package edu.ferris.seng355;

import edu.ferris.seng355.algorithms.GreedyKnapsackAlgorithm;
import edu.ferris.seng355.csv.StockDataImporter;
import edu.ferris.seng355.items.Stock;
import edu.ferris.seng355.knapsack.Knapsack;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class TestGreedyKnapsackAlgorithms {

    StockDataImporter stockDataImporter;
    GreedyKnapsackAlgorithm greedyAlgorithm;

    TestGreedyKnapsackAlgorithms() {
        stockDataImporter = new StockDataImporter();
        greedyAlgorithm = new GreedyKnapsackAlgorithm();
    }

    @Test
    void testGreedyKnapsackAlgorithmWithTenStock() throws IOException {
        double budget = 2_500;
        List<Stock> availableStock = stockDataImporter.getStocksWithWeightsAndValuesFromCSV("stock_data/10-stocks-data.csv");

        Timer timer = new Timer();
        timer.start();
        Knapsack knapsack = greedyAlgorithm.collect(availableStock, budget);
        timer.end();
        knapsack.getItems().forEach(System.out::println);

        double totalValue = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(stock -> ((stock.getPossibleNewPrice() - stock.getPrice()) * stock.getPriceIncreaseProbability())).sum();
        double totalWeight = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(Stock::getPrice).sum();

        System.out.printf("Total Profit Potential: $%,.2f, Total Weight: %f, Time Taken: %dms\n", totalValue, totalWeight, timer.getDurationInMS());
    }

    @Test
    void testGreedyKnapsackAlgorithmWithTwentyFiveStock() throws IOException {
        double budget = 2_500;
        List<Stock> availableStock = stockDataImporter.getStocksWithWeightsAndValuesFromCSV("stock_data/25-stocks-data.csv");

        Timer timer = new Timer();
        timer.start();
        Knapsack knapsack = greedyAlgorithm.collect(availableStock, budget);
        timer.end();
        knapsack.getItems().forEach(System.out::println);

        double totalValue = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(stock -> ((stock.getPossibleNewPrice() - stock.getPrice()) * stock.getPriceIncreaseProbability())).sum();
        double totalWeight = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(Stock::getPrice).sum();

        System.out.printf("Total Profit Potential: $%,.2f, Total Weight: %f, Time Taken: %dms\n", totalValue, totalWeight, timer.getDurationInMS());
    }

    @Test
    void testGreedyKnapsackAlgorithmWithFiftyStock() throws IOException {
        double budget = 2_500;
        List<Stock> availableStock = stockDataImporter.getStocksWithWeightsAndValuesFromCSV("stock_data/50-stocks-data.csv");

        Timer timer = new Timer();
        timer.start();
        Knapsack knapsack = greedyAlgorithm.collect(availableStock, budget);
        timer.end();
        knapsack.getItems().forEach(System.out::println);

        double totalValue = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(stock -> ((stock.getPossibleNewPrice() - stock.getPrice()) * stock.getPriceIncreaseProbability())).sum();
        double totalWeight = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(Stock::getPrice).sum();

        System.out.printf("Total Profit Potential: $%,.2f, Total Weight: %f, Time Taken: %dms\n", totalValue, totalWeight, timer.getDurationInMS());
    }

    @Test
    void testGreedyKnapsackAlgorithmWithOneHundredStock() throws IOException {
        double budget = 2_500;
        List<Stock> availableStock = stockDataImporter.getStocksWithWeightsAndValuesFromCSV("stock_data/100-stocks-data.csv");

        Timer timer = new Timer();
        timer.start();
        Knapsack knapsack = greedyAlgorithm.collect(availableStock, budget);
        timer.end();
        knapsack.getItems().forEach(System.out::println);

        double totalValue = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(stock -> ((stock.getPossibleNewPrice() - stock.getPrice()) * stock.getPriceIncreaseProbability())).sum();
        double totalWeight = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(Stock::getPrice).sum();

        System.out.printf("Total Profit Potential: $%,.2f, Total Weight: %f, Time Taken: %dms\n", totalValue, totalWeight, timer.getDurationInMS());
    }

    @Test
    void testGreedyKnapsackAlgorithmWithTwoHundredFiftyStock() throws IOException {
        double budget = 2_500;
        List<Stock> availableStock = stockDataImporter.getStocksWithWeightsAndValuesFromCSV("stock_data/250-stocks-data.csv");

        Timer timer = new Timer();
        timer.start();
        Knapsack knapsack = greedyAlgorithm.collect(availableStock, budget);
        timer.end();
        knapsack.getItems().forEach(System.out::println);

        double totalValue = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(stock -> ((stock.getPossibleNewPrice() - stock.getPrice()) * stock.getPriceIncreaseProbability())).sum();
        double totalWeight = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(Stock::getPrice).sum();

        System.out.printf("Total Profit Potential: $%,.2f, Total Weight: %f, Time Taken: %dms\n", totalValue, totalWeight, timer.getDurationInMS());
    }

    @Test
    void testGreedyKnapsackAlgorithmWithFiveHundredStock() throws IOException {
        double budget = 2_500;
        List<Stock> availableStock = stockDataImporter.getStocksWithWeightsAndValuesFromCSV("stock_data/500-stocks-data.csv");

        Timer timer = new Timer();
        timer.start();
        Knapsack knapsack = greedyAlgorithm.collect(availableStock, budget);
        timer.end();
        knapsack.getItems().forEach(System.out::println);

        double totalValue = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(stock -> ((stock.getPossibleNewPrice() - stock.getPrice()) * stock.getPriceIncreaseProbability())).sum();
        double totalWeight = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(Stock::getPrice).sum();

        System.out.printf("Total Profit Potential: $%,.2f, Total Weight: %f, Time Taken: %dms\n", totalValue, totalWeight, timer.getDurationInMS());
    }

    @Test
    void testGreedyKnapsackAlgorithmWithOneThousandStock() throws IOException {
        double budget = 2_500;
        List<Stock> availableStock = stockDataImporter.getStocksWithWeightsAndValuesFromCSV("stock_data/1000-stocks-data.csv");

        Timer timer = new Timer();
        timer.start();
        Knapsack knapsack = greedyAlgorithm.collect(availableStock, budget);
        timer.end();
        knapsack.getItems().forEach(System.out::println);

        double totalValue = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(stock -> ((stock.getPossibleNewPrice() - stock.getPrice()) * stock.getPriceIncreaseProbability())).sum();
        double totalWeight = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(Stock::getPrice).sum();

        System.out.printf("Total Profit Potential: $%,.2f, Total Weight: %f, Time Taken: %dms\n", totalValue, totalWeight, timer.getDurationInMS());
    }

    @Test
    void testGreedyKnapsackAlgorithmWithFiveThousandStock() throws IOException {
        double budget = 2_500;
        List<Stock> availableStock = stockDataImporter.getStocksWithWeightsAndValuesFromCSV("stock_data/5000-stocks-data.csv");

        Timer timer = new Timer();
        timer.start();
        Knapsack knapsack = greedyAlgorithm.collect(availableStock, budget);
        timer.end();
        knapsack.getItems().forEach(System.out::println);

        double totalValue = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(stock -> ((stock.getPossibleNewPrice() - stock.getPrice()) * stock.getPriceIncreaseProbability())).sum();
        double totalWeight = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(Stock::getPrice).sum();

        System.out.printf("Total Profit Potential: $%,.2f, Total Weight: %f, Time Taken: %dms\n", totalValue, totalWeight, timer.getDurationInMS());
    }

    @Test
    void testGreedyKnapsackAlgorithmWithTenThousandStock() throws IOException {
        double budget = 2_500;
        List<Stock> availableStock = stockDataImporter.getStocksWithWeightsAndValuesFromCSV("stock_data/10000-stocks-data.csv");

        Timer timer = new Timer();
        timer.start();
        Knapsack knapsack = greedyAlgorithm.collect(availableStock, budget);
        timer.end();
        knapsack.getItems().forEach(System.out::println);

        double totalValue = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(stock -> ((stock.getPossibleNewPrice() - stock.getPrice()) * stock.getPriceIncreaseProbability())).sum();
        double totalWeight = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(Stock::getPrice).sum();

        System.out.printf("Total Profit Potential: $%,.2f, Total Weight: %f, Time Taken: %dms\n", totalValue, totalWeight, timer.getDurationInMS());
    }

    @Test
    void testGreedyKnapsackAlgorithmWithFifteenThousandStock() throws IOException {
        double budget = 2_500;
        List<Stock> availableStock = stockDataImporter.getStocksWithWeightsAndValuesFromCSV("stock_data/15000-stocks-data.csv");

        Timer timer = new Timer();
        timer.start();
        Knapsack knapsack = greedyAlgorithm.collect(availableStock, budget);
        timer.end();

        knapsack.getItems().forEach(System.out::println);

        double totalValue = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(stock -> ((stock.getPossibleNewPrice() - stock.getPrice()) * stock.getPriceIncreaseProbability())).sum();
        double totalWeight = knapsack.getItems().stream().map(item -> (Stock) item).mapToDouble(Stock::getPrice).sum();

        System.out.printf("Total Profit Potential: $%,.2f, Total Weight: %f, Time Taken: %dms\n", totalValue, totalWeight, timer.getDurationInMS());
    }

}
