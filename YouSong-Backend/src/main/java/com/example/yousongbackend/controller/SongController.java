package com.example.yousongbackend.controller;

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
@RequestMapping("/api/songs")
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping
    public Page<Song> getAllSongs(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return songRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/{search}")
    public Page<Song> getSongsBySearch(@PathVariable String search,@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return songRepository.findByTitleContainingIgnoreCaseOrArtist_NameContainingIgnoreCase(search,search,PageRequest.of(page, size));
    }

    @PostMapping
    public Song createSong(@Valid @RequestBody Song song) {
        return songRepository.save(song);
    }

    @PutMapping("/{id}")
    public Song updateSong(@PathVariable long id, @Valid @RequestBody Song updatedSong) {
        Song song = songRepository.findById(id);
        song.setTitle(updatedSong.getTitle());
        song.setArtist(updatedSong.getArtist());
        song.setGenre(updatedSong.getGenre());
        song.setLength(updatedSong.getLength());
        return songRepository.save(song);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable long id) {
        Song song = songRepository.findById(id);
        songRepository.delete(song);
    }
}
