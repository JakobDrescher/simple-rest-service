package com.example.yousongbackend.song;

import com.example.yousongbackend.artist.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    Song findById(long id);

    List<Song> findByArtist(Artist artist);

    List<Song> findByTitleContainingIgnoreCase(String title);
}
