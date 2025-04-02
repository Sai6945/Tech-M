package daay7;

import java.util.concurrent.*;

class FlightBookingSystem {
    private int availableSeats;

    public FlightBookingSystem(int seats) {
        this.availableSeats = seats;
    }

    // Synchronized method to prevent race conditions
    public synchronized String bookTicket(String passengerName) {
        if (availableSeats > 0) {
            availableSeats--;
            return "✅ Ticket booked for " + passengerName + ". Seats left: " + availableSeats;
        } else {
            return "❌ No seats available for " + passengerName;
        }
    }
}

class Passenger implements Callable<String> {
    private final FlightBookingSystem system;
    private final String name;

    public Passenger(FlightBookingSystem system, String name) {
        this.system = system;
        this.name = name;
    }

    @Override
    public String call() {
        return system.bookTicket(name);
    }
}

public class FlightTicketBookingSystem {
    public static void main(String[] args) {
        FlightBookingSystem system = new FlightBookingSystem(3); // Only 3 seats available
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Create passengers requesting tickets
        Future<String> p1 = executor.submit(new Passenger(system, "Alice"));
        Future<String> p2 = executor.submit(new Passenger(system, "Bob"));
        Future<String> p3 = executor.submit(new Passenger(system, "Charlie"));
        Future<String> p4 = executor.submit(new Passenger(system, "David"));
        Future<String> p5 = executor.submit(new Passenger(system, "Eve"));

        // Get booking confirmations
        try {
            System.out.println(p1.get());
            System.out.println(p2.get());
            System.out.println(p3.get());
            System.out.println(p4.get());
            System.out.println(p5.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Shutdown executor
        executor.shutdown();
    }
}
