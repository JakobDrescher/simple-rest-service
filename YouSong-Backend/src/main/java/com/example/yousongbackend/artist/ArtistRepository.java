package com.example.yousongbackend.artist;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends PagingAndSortingRepository<Artist, Long>, CrudRepository<Artist, Long> {
    Artist findById(long id);

    Page<Artist> findByNameContainingIgnoreCase(String name, Pageable pageable);
}