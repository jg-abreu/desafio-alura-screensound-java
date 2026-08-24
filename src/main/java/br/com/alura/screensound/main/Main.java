package br.com.alura.screensound.main;

import br.com.alura.screensound.model.Artist;
import br.com.alura.screensound.model.ArtistType;
import br.com.alura.screensound.model.Song;
import br.com.alura.screensound.repository.ArtistRepository;

import java.util.List;
import java.util.Optional;
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
        System.out.println("Register song for which artist? ");
        var artistName = scanner.nextLine();

        Optional<Artist> optionalArtist = repository.findByNameContainingIgnoreCase(artistName);

        if (optionalArtist.isPresent()) {
            Artist artist = optionalArtist.get();

            System.out.println("Enter song title: ");
            var title = scanner.nextLine();

            System.out.println("Enter album name: ");
            var album = scanner.nextLine();

            Song song = new Song(title, album, artist);
            artist.getSongs().add(song);
            repository.save(artist);

            System.out.println("Song '" + title + "' registered successfully for artist '" + artist.getName() + "'!");
        } else {
            System.out.println("Artist not found with name: " + artistName);
        }
    }

    private void listSongs() {
        List<Artist> artists = repository.findAll();

        if (artists.isEmpty()) {
            System.out.println("No artists or songs registered yet.");
            return;
        }

        System.out.println("\n--- All Registered Songs ---");
        artists.forEach(artist ->
                artist.getSongs().forEach(song ->
                        System.out.println("Artist: " + artist.getName() + " | " + song)
                )
        );
    }

    private void searchSongsByArtist() {
        System.out.println("Search songs for which artist? ");
        var artistName = scanner.nextLine();

        List<Song> songs = repository.findSongsByArtistName(artistName);

        if (songs.isEmpty()) {
            System.out.println("No songs found for artist: " + artistName);
        } else {
            System.out.println("\n--- Songs Found ---");
            songs.forEach(System.out::println);
        }
    }

    private void searchArtistDetails() {
        System.out.println("Search details for which artist? ");
        var artistName = scanner.nextLine();

        var details = br.com.alura.screensound.service.WikipediaQueryService.getArtistDetails(artistName);
        System.out.println("\n--- Artist Information ---");
        System.out.println(details);
    }
}