package com.example.yousongbackend.controller;

import com.example.yousongbackend.song.Song;
import com.example.yousongbackend.song.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/songs")
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @PostMapping("/songs")
    public Song createSong(@RequestBody Song song) {
        return songRepository.save(song);
    }
}
