import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Movie {
    private int id;
    private String title;
    private String director;
    private int year;
    private String genre;

    public Movie(int id, String title, String director, int year, String genre) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.year = year;
        this.genre = genre;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }

    @Override
    public String toString() {
        return "Movie ID: " + id +
                "\nTitle: " + title +
                "\nDirector: " + director +
                "\nYear: " + year +
                "\nGenre: " + genre +
                "\n-------------------------";
    }
}

public class Moviedatabase {
    private static List<Movie> movies = new ArrayList<>();
    private static int movieIdCounter = 1;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> addMovie();
                case 2 -> searchMovie();
                case 3 -> displayAllMovies();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice!");
            }
        }
        System.out.println("Exiting Movie Database...");
    }

    private static void printMenu() {
        System.out.println("\n Movie Database Menu");
        System.out.println("1. Add New Movie");
        System.out.println("2. Search Movie by Title");
        System.out.println("3. Display All Movies");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private static void addMovie() {
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter director: ");
        String director = sc.nextLine();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter genre: ");
        String genre = sc.nextLine();

        Movie movie = new Movie(movieIdCounter++, title, director, year, genre);
        movies.add(movie);
        System.out.println("✅ Movie added successfully!");
    }

    private static void searchMovie() {
        System.out.print("Enter title to search: ");
        String search = sc.nextLine().toLowerCase();
        boolean found = false;

        for (Movie m : movies) {
            if (m.getTitle().toLowerCase().contains(search)) {
                System.out.println(m);
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ No movies found with that title.");
        }
    }

    private static void displayAllMovies() {
        if (movies.isEmpty()) {
            System.out.println("No movies in database.");
            return;
        }
        System.out.println("\n--- Movie List ---");
        for (Movie m : movies) {
            System.out.println(m);
        }
    }
}
