package com.example.yousongbackend;

import com.example.yousongbackend.artist.Artist;
import com.example.yousongbackend.artist.ArtistRepository;
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
    @Autowired
    private ArtistRepository artistRepository;

    public static void main(String[] args) {
        SpringApplication.run(YouSongBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Artist sixTinJonesy = new Artist("Six Tin Jonesy");
        Artist ironMaiden = new Artist("Iron Maiden");
        Artist windRose = new Artist("Wind Rose");
        Artist metallica = new Artist("Metallica");
        Artist capcomSoundTeam = new Artist("Capcom Sound Team");
        Artist johnPaesano = new Artist("John Paesano");
        Artist bearMcCreary = new Artist("Bear McCreary");
        Artist alanSilvestri = new Artist("Alan Silvestri");
        Artist danielPemberton = new Artist("Daniel Pemberton");
        Artist unpeople = new Artist("unpeople");

        artistRepository.save(sixTinJonesy);
        artistRepository.save(ironMaiden);
        artistRepository.save(windRose);
        artistRepository.save(metallica);
        artistRepository.save(capcomSoundTeam);
        artistRepository.save(johnPaesano);
        artistRepository.save(bearMcCreary);
        artistRepository.save(alanSilvestri);
        artistRepository.save(danielPemberton);
        artistRepository.save(unpeople);

        songRepository.save(new Song("Void",sixTinJonesy,"punks-ska",LocalTime.of(0,3,44)));
        songRepository.save(new Song("Neverresting Eyes",sixTinJonesy,"punks-ska",LocalTime.of(0,2,33)));

        songRepository.save(new Song("The Trooper",ironMaiden,"metal",LocalTime.of(0,4,13)));
        songRepository.save(new Song("Charlot the Harlot",sixTinJonesy,"metal",LocalTime.of(0,4,13)));

        songRepository.save(new Song("Rock and Stone",windRose,"tolkien metal",LocalTime.of(0,5,5)));
        songRepository.save(new Song("There and Back Again",windRose,"tolkien metal",LocalTime.of(0,6,19)));

        songRepository.save(new Song("Master Of Puppets",metallica,"metal",LocalTime.of(0,8,35)));
        songRepository.save(new Song("Moth Into Flame",metallica,"metal",LocalTime.of(0,5,50)));

        songRepository.save(new Song("The Legend Descends",capcomSoundTeam,"video game soundtrack",LocalTime.of(0,5,11)));
        songRepository.save(new Song("Proof of a Hero - Monster Hunter World edition",capcomSoundTeam,"punks-ska",LocalTime.of(0,3,13)));

        songRepository.save(new Song("Greater Together",johnPaesano,"video game soundtrack",LocalTime.of(0,3,18)));
        songRepository.save(new Song("Eight Years in the Making",johnPaesano,"video game soundtrack",LocalTime.of(0,2,2)));

        songRepository.save(new Song("A Son's Path",bearMcCreary,"video game soundtrack",LocalTime.of(0,3,31)));
        songRepository.save(new Song("God of War Ragnarök",bearMcCreary,"video game soundtrack",LocalTime.of(0,4,35)));

        songRepository.save(new Song("Portals",alanSilvestri,"movie soundtrack",LocalTime.of(0,3,17)));
        songRepository.save(new Song("The Real Hero",alanSilvestri,"movie soundtrack",LocalTime.of(0,5,55)));

        songRepository.save(new Song("Across the Spider-Verse (Intro)",danielPemberton,"movie soundtrack",LocalTime.of(0,2,45)));
        songRepository.save(new Song("Nueva York Train Chase",danielPemberton,"movie soundtrack",LocalTime.of(0,5,58)));

        songRepository.save(new Song("the graden",unpeople,"metal",LocalTime.of(0,3,23)));
        songRepository.save(new Song("waste",unpeople,"metal",LocalTime.of(0,3,51)));
    }
}
