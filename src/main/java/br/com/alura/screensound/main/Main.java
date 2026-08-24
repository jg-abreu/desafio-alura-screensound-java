package br.com.alura.screensound.main;

import br.com.alura.screensound.model.Artist;
import br.com.alura.screensound.model.ArtistType;
import br.com.alura.screensound.repository.ArtistRepository;

import java.util.Scanner;

public class Main {

    private final ArtistRepository repository;
    private final Scanner scanner = new Scanner(System.in);

    public Main(ArtistRepository repository) {
        this.repository = repository;
    }

    public void showMenu() {
        var option = -1;

        while (option != 9) {
            var menu = """
                \n*** Screen Sound Music ***
                
                1 - Register artists
                2 - Register songs
                3 - List songs
                4 - Search songs by artist
                5 - Search artist details
                
                9 - Exit
                """;

            System.out.println(menu);

            try {
                option = scanner.nextInt();
                scanner.nextLine(); // Consome a quebra de linha deixada pelo nextInt()
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (option) {
                case 1 -> registerArtist();
                case 2 -> registerSong();
                case 3 -> listSongs();
                case 4 -> searchSongsByArtist();
                case 5 -> searchArtistDetails();
                case 9 -> System.out.println("Exiting Screen Sound...");
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void registerArtist() {
        var registerMore = "Y";

        while (registerMore.equalsIgnoreCase("Y")) {
            System.out.print("Enter artist name: ");
            var name = scanner.nextLine();

            System.out.print("Enter artist type (SOLO, DUO, BAND): ");
            var typeInput = scanner.nextLine();

            try {
                ArtistType type = ArtistType.fromString(typeInput);
                Artist artist = new Artist(name, type);
                repository.save(artist);
                System.out.println("Artist '" + name + "' registered successfully!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.print("Do you want to register another artist? (Y/N): ");
            registerMore = scanner.nextLine();
        }
    }

    private void registerSong() {
        // Implementaremos no próximo passo
    }

    private void listSongs() {
        // Implementaremos no próximo passo
    }

    private void searchSongsByArtist() {
        // Implementaremos no próximo passo
    }

    private void searchArtistDetails() {
        // Implementaremos no próximo passo
    }
}