package Day6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

// Flight Class
class Flight {
    private final String flightNumber;
    private final String destination;
    private final LocalDateTime departureTime;
    private final int duration; // in minutes
    private final double price;

    public Flight(String flightNumber, String destination, LocalDateTime departureTime, int duration, double price) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureTime = departureTime;
        this.duration = duration;
        this.price = price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public int getDuration() {
        return duration;
    }

    public double getPrice() {
        return price;
    }
}

// Flight Booking System
public class FlightBookingSystem {
    public static void main(String[] args) {
        List<Flight> flights = Arrays.asList(
            new Flight("FL123", "New York", LocalDateTime.now().plusHours(2), 180, 350.0),
            new Flight("FL456", "Los Angeles", LocalDateTime.now().plusHours(5), 240, 280.0),
            new Flight("FL789", "Chicago", LocalDateTime.now().plusHours(7), 150, 220.0),
            new Flight("FL321", "New York", LocalDateTime.now().plusHours(3), 175, 400.0)
        );

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm a");
        LocalDateTime sixHoursFromNow = LocalDateTime.now().plusHours(6);

        // Find all flights departing within the next 6 hours
        List<Flight> upcomingFlights = flights.stream()
            .filter(flight -> flight.getDepartureTime().isBefore(sixHoursFromNow))
            .collect(Collectors.toList());

        // Find the cheapest flight for a given destination
        String destination = "New York";
        Optional<Flight> cheapestFlight = flights.stream()
            .filter(flight -> flight.getDestination().equalsIgnoreCase(destination))
            .min(Comparator.comparingDouble(Flight::getPrice));

        // Find the fastest flight (shortest duration)
        Optional<Flight> fastestFlight = flights.stream()
            .min(Comparator.comparingInt(Flight::getDuration));

        // Display results
        System.out.println("Flights departing within the next 6 hours:");
        upcomingFlights.forEach(flight -> System.out.println(flight.getFlightNumber() + " - " + flight.getDestination() + " - " + flight.getDepartureTime().format(formatter)));
        
        System.out.println("\nCheapest flight to " + destination + ": " + cheapestFlight.map(f -> f.getFlightNumber() + " - $" + f.getPrice()).orElse("No flights available"));
        
        System.out.println("\nFastest flight: " + fastestFlight.map(f -> f.getFlightNumber() + " - " + f.getDuration() + " minutes").orElse("No flights available"));
    }
}
