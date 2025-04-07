package com.example.yousongbackend.song;

import com.example.yousongbackend.artist.Artist;
import com.example.yousongbackend.artist.ArtistRepository;
import com.example.yousongbackend.validation.ArtistExists;
import com.example.yousongbackend.validation.NotZeroTime;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "Title must be provided")
    private String title;
    @ManyToOne
    private Artist artist;
    @NotBlank(message = "Genre must be provided")
    private String genre;
    @NotZeroTime
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
