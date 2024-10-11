package com.example.yousongbackend;

import com.example.yousongbackend.song.Song;
import com.example.yousongbackend.song.SongRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalTime;

@SpringBootApplication
public class YouSongBackendApplication implements CommandLineRunner {

    @Autowired
    private SongRepository songRepository;

    public static void main(String[] args) {
        SpringApplication.run(YouSongBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        songRepository.save(new Song("INVISIBLE","Duran Duran","synthpop", LocalTime.of(0,3,11)));
        songRepository.save(new Song("Void","Six Tin Jonesy","punk ska", LocalTime.of(0,3,44)));
        songRepository.save(new Song("Rock and Stone","Wind Rose","tolkien metal", LocalTime.of(0,5,5)));
        songRepository.save(new Song("God of War Ragnarök (feat. Eivør)","Bear McCreary","soundtrack", LocalTime.of(0,4,35)));
        songRepository.save(new Song("Nueva York Train Chase","Daniel Pemberton","soundtrack", LocalTime.of(0,5,58)));
    }
}
