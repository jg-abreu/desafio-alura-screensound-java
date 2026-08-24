package br.com.alura.screensound.main;

import java.util.Scanner;

public class Main {

    private Scanner sc = new Scanner(System.in);

    public void showMenu() {
        var option = -1;

        while (option != 9) {
            var menu = """
                *** Screen Sound Music ***
                
                1 - Register artists
                2 - Register songs
                3 - List songs
                4 - Search songs by artist
                5 - Search artist details
                
                9 - Exit
                """;

            System.out.println(menu);
            option = sc.nextInt();
            sc.nextInt();

            switch (option) {
                case 1:
                    registerArtist();
                    break;
                case 2:
                    registerSong();
                    break;
                case 3:
                    listSongs();
                    break;
                case 4:
                    searchSongsByArtist();
                    break;
                case 5:
                    searchArtistDetails();
                    break;
            }
    }
}

    private void registerArtist() {
    }

    private void registerSong() {
    }

    private void listSongs() {
    }

    private void searchSongsByArtist() {
    }

    private void searchArtistDetails() {
    }
