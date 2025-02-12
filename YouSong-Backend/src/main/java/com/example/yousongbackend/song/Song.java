package com.example.yousongbackend.song;

import com.example.yousongbackend.artist.Artist;
import com.example.yousongbackend.artist.ArtistRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    @ManyToOne
    private Artist artist;
    private String genre;
    private LocalTime length;

    public Song(String title, Artist artist, String genre, LocalTime length) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", length=" + length +
                '}';
    }
}
