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

        songRepository.save(new Song("Silver-winged Star - Valstrax","Capcom Sound Team","soundtrack", LocalTime.of(0,4,3)));
        songRepository.save(new Song("The Shire","Howard Shore","soundtrack", LocalTime.of(0,3,44)));
        songRepository.save(new Song("Cyanide","Metallica","metal", LocalTime.of(0,6,40)));
        songRepository.save(new Song("Moth Into Flame","Metallica","metal", LocalTime.of(0,5,51)));
        songRepository.save(new Song("Painkiller","Judas Priest","metal", LocalTime.of(0,6,6)));

        songRepository.save(new Song("Killer Queen","Queen","pop", LocalTime.of(0,3,0)));
        songRepository.save(new Song("i wish that i could wear hats","Brian David Gilber","indie", LocalTime.of(0,1,26)));
        songRepository.save(new Song("Rainbow in the Dark","Dio","metal", LocalTime.of(0,4,13)));
        songRepository.save(new Song("Chop Suey!","System Of A Down","metal", LocalTime.of(0,3,30)));
        songRepository.save(new Song("To My Son","Daniel Pemberton","soundtrack", LocalTime.of(0,1,42)));

        songRepository.save(new Song("waste","unpeople","metal", LocalTime.of(0,3,51)));
        songRepository.save(new Song("smother","unpeople","metal", LocalTime.of(0,3,21)));
        songRepository.save(new Song("going numb","unpeople","metal", LocalTime.of(0,3,25)));
        songRepository.save(new Song("overthinking","unpeople","metal", LocalTime.of(0,3,31)));
        songRepository.save(new Song("moon baboon","unpeople","metal", LocalTime.of(0,4,16)));
    }
}
