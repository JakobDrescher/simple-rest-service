package com.example.yousongbackend.controller;

import com.example.yousongbackend.artist.ArtistRepository;
import com.example.yousongbackend.song.Song;
import com.example.yousongbackend.song.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class SongController {

    @Autowired
    private SongRepository songRepository;
    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/songs")
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @GetMapping("/songs/{search}")
    public List<Song> getSongsBySearch(@PathVariable String search) {
        List<Song> result = new ArrayList<>();
        result.addAll(songRepository.findByTitleContainingIgnoreCase(search));
        artistRepository.findByNameContainingIgnoreCase(search).forEach(artist -> {
            result.addAll(songRepository.findByArtist(artist));
        });
        return result;
    }

    @PostMapping("/songs")
    public Song createSong(@RequestBody Song song) {
        return songRepository.save(song);
    }

    @PutMapping("/songs/{id}")
    public Song updateSong(@PathVariable long id, @RequestBody Song updatedSong) {
        Song song = songRepository.findById(id);
        song.setTitle(updatedSong.getTitle());
        song.setArtist(updatedSong.getArtist());
        song.setGenre(updatedSong.getGenre());
        song.setLength(updatedSong.getLength());
        return songRepository.save(song);
    }

    @DeleteMapping("/songs/{id}")
    public void deleteSong(@PathVariable long id) {
        Song song = songRepository.findById(id);
        songRepository.delete(song);
    }
}
