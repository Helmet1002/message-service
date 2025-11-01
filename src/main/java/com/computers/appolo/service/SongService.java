package com.computers.appolo.service;

import com.computers.appolo.entity.Song;
import com.computers.appolo.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepo;

    public Song addSong(Song song) {
        return songRepo.save(song);
    }

    public List<Song> listAll() {
        return songRepo.findAll();
    }

    public List<Song> searchByTitle(String title) {
        return songRepo.findByTitleContainingIgnoreCase(title);
    }

    public List<Song> searchByArtist(String artist) {
        return songRepo.findByArtistContainingIgnoreCase(artist);
    }

    public List<Song> searchByGenre(String genre) {
        return songRepo.findByGenreContainingIgnoreCase(genre);
    }
}
