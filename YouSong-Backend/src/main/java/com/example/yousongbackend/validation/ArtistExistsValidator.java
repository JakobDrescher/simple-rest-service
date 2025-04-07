package com.example.yousongbackend.validation;

import com.example.yousongbackend.artist.Artist;
import com.example.yousongbackend.artist.ArtistRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArtistExistsValidator implements ConstraintValidator<ArtistExists, Artist> {
    @Autowired
    private ArtistRepository artistRepository;

    @Override
    public boolean isValid(Artist artist, ConstraintValidatorContext constraintValidatorContext) {
        return artist != null && artistRepository.existsById(artist.getId());
    }

    @Override
    public void initialize(ArtistExists constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
