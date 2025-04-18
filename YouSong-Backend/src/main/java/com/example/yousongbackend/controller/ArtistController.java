package com.example.yousongbackend.controller;

import com.example.yousongbackend.artist.Artist;
import com.example.yousongbackend.artist.ArtistRepository;
import com.example.yousongbackend.song.Song;
import com.example.yousongbackend.song.SongRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/artists")
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private SongRepository songRepository;

    @GetMapping
    public Page<Artist> getAllArtists(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return artistRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/{search}")
    public Page<Artist> getAllArtists(@PathVariable String search, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return artistRepository.findByNameContainingIgnoreCase(search, PageRequest.of(page, size));
    }

    @PostMapping
    public Artist createArtist(@Valid @RequestBody Artist artist) {
        return artistRepository.save(artist);
    }

    @PutMapping("/{id}")
    public Artist updateSong( @PathVariable long id, @Valid @RequestBody Artist updatedArtist) {
        Artist artist = artistRepository.findById(id);
        artist.setName(updatedArtist.getName());
        return artistRepository.save(artist);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable long id) {
        Artist artist = artistRepository.findById(id);
        List<Song> songs = songRepository.findByArtist(artist);
        songs.stream().map(song -> {
            song.setArtist(null);
            return song;
        }).forEach(song-> {
            songRepository.save(song);
        });
        artistRepository.delete(artist);
    }
}
