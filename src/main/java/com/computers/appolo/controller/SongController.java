package com.computers.appolo.controller;

import com.computers.appolo.entity.Song;
import com.computers.appolo.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Song addSong(@RequestBody Song song) {
        return songService.addSong(song);
    }

    @GetMapping
    public List<Song> listSongs() {
        return songService.listAll();
    }

    @GetMapping("/search")
    public List<Song> searchSongs(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String artist,
            @RequestParam(required = false) String genre
    ) {
        if (title != null) return songService.searchByTitle(title);
        if (artist != null) return songService.searchByArtist(artist);
        if (genre != null) return songService.searchByGenre(genre);

        return songService.listAll();
    }
}
