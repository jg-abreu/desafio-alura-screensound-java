package br.com.alura.screensound.model;

import jakarta.persistence.*;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String album;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    public Song() {}

    public Song(String title, String album, Artist artist) {
        this.title = title;
        this.album = album;
        this.artist = artist;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Song: " + title + " | Album: " + album + " | Artist: " + (artist != null ? artist.getName() : "N/A");
    }
}