package Day6;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

// Movie Class
class Movie {
    private final String title;
    private final String genre;
    private final double rating;
    private final LocalDate releaseDate;

    public Movie(String title, String genre, double rating, LocalDate releaseDate) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }
}

// Movie Recommendation System
public class MovieRecommendationSystem {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Inception", "Sci-Fi", 8.8, LocalDate.of(2010, 7, 16)),
            new Movie("The Dark Knight", "Action", 9.0, LocalDate.of(2008, 7, 18)),
            new Movie("Interstellar", "Sci-Fi", 8.6, LocalDate.of(2014, 11, 7)),
            new Movie("Parasite", "Drama", 8.6, LocalDate.of(2019, 5, 30)),
            new Movie("Avengers: Endgame", "Action", 8.4, LocalDate.of(2019, 4, 26))
        );

        // Sort movies by rating (descending) and release date (newest first)
        List<Movie> sortedMovies = movies.stream()
            .sorted(Comparator.comparingDouble(Movie::getRating).reversed()
                .thenComparing(Movie::getReleaseDate, Comparator.reverseOrder()))
            .collect(Collectors.toList());

        // Filter movies based on minimum rating and genre selection
        double minRating = 8.5;
        String selectedGenre = "Sci-Fi";
        List<Movie> recommendedMovies = movies.stream()
            .filter(m -> m.getRating() > minRating && m.getGenre().equalsIgnoreCase(selectedGenre))
            .collect(Collectors.toList());

        // Get a random top-rated movie recommendation (if available)
        Optional<Movie> topRecommendation = recommendedMovies.stream()
            .findAny();

        // Display sorted movies
        System.out.println("Movies sorted by rating and release date:");
        sortedMovies.forEach(m -> System.out.println(m.getTitle() + " - " + m.getRating() + " - " + m.getReleaseDate()));

        // Display recommended movies
        System.out.println("\nRecommended " + selectedGenre + " movies with rating > " + minRating + ":");
        recommendedMovies.forEach(m -> System.out.println(m.getTitle() + " - " + m.getRating()));

        // Display a random top-rated recommendation
        System.out.println("\nTop Recommendation: " + topRecommendation.map(Movie::getTitle).orElse("No Recommendation Available"));
    }
}