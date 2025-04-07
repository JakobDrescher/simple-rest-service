package com.example.yousongbackend.song;

import com.example.yousongbackend.artist.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends PagingAndSortingRepository<Song, Long>, CrudRepository<Song, Long> {
    Song findById(long id);
    List<Song> findByArtist(Artist artist);
    Page<Song> findByTitleContainingIgnoreCaseOrArtist_NameContainingIgnoreCase(String title, String artist, Pageable pageable);
}
