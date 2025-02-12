package com.example.yousongbackend.controller;

import com.example.yousongbackend.artist.Artist;
import com.example.yousongbackend.artist.ArtistRepository;
import com.example.yousongbackend.song.Song;
import com.example.yousongbackend.song.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;
    @Autowired
    private SongRepository songRepository;

    @GetMapping("/artists")
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @PostMapping("/artists")
    public Artist createArtist(@RequestBody Artist artist) {
        return artistRepository.save(artist);
    }

    @PutMapping("/artists/{id}")
    public Artist updateSong(@PathVariable long id, @RequestBody Artist updatedArtist) {
        Artist artist = artistRepository.findById(id);
        artist.setName(updatedArtist.getName());
        return artistRepository.save(artist);
    }

    @DeleteMapping("/artists/{id}")
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
