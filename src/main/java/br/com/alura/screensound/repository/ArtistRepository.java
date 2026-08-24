package br.com.alura.screensound.repository;

import br.com.alura.screensound.model.Artist;
import br.com.alura.screensound.model.ArtistType;
import br.com.alura.screensound.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Optional<Artist> findByNameContainingIgnoreCase(String name);

    List<Artist> findByType(ArtistType type);

    @Query("SELECT s FROM Artist a JOIN a.songs s WHERE a = :artist")
    List<Song> findSongsByArtist(Artist artist);

    @Query("SELECT s FROM Artist a JOIN a.songs s WHERE LOWER(s.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Song> findSongsByTitle(String title);
}