package com.example.yousongbackend.song;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    Song findById(long id);

    List<Song> findByArtistContainingIgnoreCase(String search);

    List<Song> findByTitleContainingIgnoreCase(String title);
}
