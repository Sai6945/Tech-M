package Day5;

import java.util.*;

//Bid class representing a bid with amount and timestamp
class Bid {
 private String bidder;
 private double amount;
 private long timestamp;

 public Bid(String bidder, double amount) {
     this.bidder = bidder;
     this.amount = amount;
     this.timestamp = System.currentTimeMillis();
 }

 public double getAmount() {
     return amount;
 }

 public long getTimestamp() {
     return timestamp;
 }

 public String getBidder() {
     return bidder;
 }

 @Override
 public String toString() {
     return "Bidder: " + bidder + ", Amount: $" + amount + ", Time: " + timestamp;
 }
}

//Comparator for prioritizing bids (higher amount first, earlier bids in case of tie)
class BidComparator implements Comparator<Bid> {
 @Override
 public int compare(Bid b1, Bid b2) {
     if (Double.compare(b2.getAmount(), b1.getAmount()) == 0) {
         return Long.compare(b1.getTimestamp(), b2.getTimestamp());
     }
     return Double.compare(b2.getAmount(), b1.getAmount());
 }
}

//Generic Auction class for handling bids on any item type
class Auction<T> {
 private T item;
 private PriorityQueue<Bid> bidQueue;

 public Auction(T item) {
     this.item = item;
     this.bidQueue = new PriorityQueue<>(new BidComparator());
 }

 public void placeBid(String bidder, double amount) {
     bidQueue.offer(new Bid(bidder, amount));
     System.out.println("New bid placed: " + bidder + " - $" + amount);
 }

 public void processHighestBid() {
     Bid highestBid = bidQueue.poll();
     if (highestBid != null) {
         System.out.println("Winning bid: " + highestBid);
     } else {
         System.out.println("No bids available.");
     }
 }

 public void displayAllBids() {
     System.out.println("All bids for " + item + ":");
     for (Bid bid : bidQueue) {
         System.out.println(bid);
     }
 }
}

//Main class to demonstrate the auction system
public class OnlineAuctionSystem {
 public static void main(String[] args) {
     Auction<String> auction = new Auction<>("Laptop");
     
     auction.placeBid("Alice", 500);
     auction.placeBid("Bob", 600);
     auction.placeBid("Charlie", 550);
     auction.placeBid("David", 600); // Same amount, earlier bid gets priority
     
     auction.displayAllBids();
     
     System.out.println("\nProcessing the highest bid:");
     auction.processHighestBid();
 }
}