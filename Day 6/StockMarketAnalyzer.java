package Day6;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

// Stock Class
class Stock {
    private final String symbol;
    private final double price;
    private final int volume;
    private final LocalDateTime lastTradeTime;

    public Stock(String symbol, double price, int volume, LocalDateTime lastTradeTime) {
        this.symbol = symbol;
        this.price = price;
        this.volume = volume;
        this.lastTradeTime = lastTradeTime;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }

    public LocalDateTime getLastTradeTime() {
        return lastTradeTime;
    }
}

// Stock Market Data Analyzer
public class StockMarketAnalyzer {
    public static void main(String[] args) {
        List<Stock> stocks = Arrays.asList(
            new Stock("AAPL", 175.30, 12000, LocalDateTime.now().minusHours(5)),
            new Stock("GOOGL", 2800.50, 8000, LocalDateTime.now().minusHours(10)),
            new Stock("TSLA", 900.75, 15000, LocalDateTime.now().minusDays(2)),
            new Stock("MSFT", 310.20, 11000, LocalDateTime.now().minusHours(3)),
            new Stock("AMZN", 3450.00, 7000, LocalDateTime.now().minusHours(20))
        );

        // Find the highest-priced stock
        Optional<Stock> highestPricedStock = stocks.stream()
            .max(Comparator.comparingDouble(Stock::getPrice));

        // Calculate the average stock price
        OptionalDouble averagePrice = stocks.stream()
            .mapToDouble(Stock::getPrice)
            .average();

        // List stocks with trading activity in the last 24 hours
        LocalDateTime twentyFourHoursAgo = LocalDateTime.now().minusHours(24);
        List<Stock> activeStocks = stocks.stream()
            .filter(stock -> stock.getLastTradeTime().isAfter(twentyFourHoursAgo))
            .collect(Collectors.toList());

        // Display results
        System.out.println("Highest Priced Stock: " + highestPricedStock.map(s -> s.getSymbol() + " - $" + s.getPrice()).orElse("No Data"));
        System.out.println("Average Stock Price: " + (averagePrice.isPresent() ? "$" + averagePrice.getAsDouble() : "No Data"));

        System.out.println("\nStocks traded in the last 24 hours:");
        activeStocks.forEach(stock -> System.out.println(stock.getSymbol() + " - $" + stock.getPrice() + " - " + stock.getLastTradeTime()));
    }
}
