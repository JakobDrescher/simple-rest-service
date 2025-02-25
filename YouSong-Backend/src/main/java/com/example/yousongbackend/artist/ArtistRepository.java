package com.example.yousongbackend.artist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Artist findById(long id);

    List<Artist> findByNameContainingIgnoreCase(String name);
}