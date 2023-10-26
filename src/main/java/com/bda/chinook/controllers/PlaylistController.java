package com.bda.chinook.controllers;

import com.bda.chinook.entities.Track;
import com.bda.chinook.entities.dto.PlaylistDto;
import com.bda.chinook.services.PlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {
    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping
    public ResponseEntity<List<PlaylistDto>> getAll() {
        List<PlaylistDto> values = playlistService.getAll();
        return ResponseEntity.ok(values);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaylistDto> getById(@PathVariable("id") int id) {
        PlaylistDto value = playlistService.getById(id);
        return ResponseEntity.ok(value);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody PlaylistDto entity) {
        playlistService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody PlaylistDto entity) {
        playlistService.update(entity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        playlistService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{playlistId}/tracks")
    public ResponseEntity<List<Track>> getTracksInPlaylist(@PathVariable int playlistId) {
        List<Track> tracks = playlistService.getTracksInPlaylist(playlistId);
        return ResponseEntity.ok(tracks);
    }
}
