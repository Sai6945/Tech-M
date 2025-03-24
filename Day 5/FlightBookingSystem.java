package Day5;

import java.util.*;

//Passenger class
class Passenger {
 String name;
 String ticketClass; // Business, Economy, General
 long bookingTime;

 public Passenger(String name, String ticketClass, long bookingTime) {
     this.name = name;
     this.ticketClass = ticketClass;
     this.bookingTime = bookingTime;
 }

 @Override
 public String toString() {
     return name + " - " + ticketClass + " - " + bookingTime;
 }
}

//Comparator for priority queue
class PassengerComparator implements Comparator<Passenger> {
 private static final Map<String, Integer> CLASS_PRIORITY = Map.of(
     "Business", 1,
     "Economy", 2,
     "General", 3
 );
 
 @Override
 public int compare(Passenger p1, Passenger p2) {
     int classCompare = Integer.compare(CLASS_PRIORITY.get(p1.ticketClass), CLASS_PRIORITY.get(p2.ticketClass));
     if (classCompare == 0) {
         return Long.compare(p1.bookingTime, p2.bookingTime);
     }
     return classCompare;
 }
}

public class FlightBookingSystem {
 private PriorityQueue<Passenger> bookingQueue = new PriorityQueue<>(new PassengerComparator());

 public void addPassenger(String name, String ticketClass) {
     long bookingTime = System.currentTimeMillis();
     bookingQueue.offer(new Passenger(name, ticketClass, bookingTime));
 }

 public void processNextPassenger() {
     if (!bookingQueue.isEmpty()) {
         System.out.println("Processing: " + bookingQueue.poll());
     } else {
         System.out.println("No more passengers.");
     }
 }

 public void listPassengers() {
     Iterator<Passenger> iterator = bookingQueue.iterator();
     while (iterator.hasNext()) {
         System.out.println(iterator.next());
     }
 }

 public static void main(String[] args) {
     FlightBookingSystem fbs = new FlightBookingSystem();
     fbs.addPassenger("Alice", "Business");
     fbs.addPassenger("Bob", "Economy");
     fbs.addPassenger("Charlie", "General");
     fbs.addPassenger("David", "Business");
     fbs.addPassenger("Eve", "Economy");

     System.out.println("\nPassengers in Queue:");
     fbs.listPassengers();

     System.out.println("\nProcessing Passengers:");
     fbs.processNextPassenger();
     fbs.processNextPassenger();
 }
}
