//package com.bda.chinook.controllers;
//
//import com.bda.chinook.entities.dto.PlaylistTrackDto;
//import com.bda.chinook.services.PlaylistTrackService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/trackController")
//public class PlaylistTrackController {
//    private final PlaylistTrackService playlistTrackService;
//
//    public PlaylistTrackController(PlaylistTrackService playlistTrackService) {
//        this.playlistTrackService = playlistTrackService;
//    }
//    @GetMapping
//    public ResponseEntity<List<PlaylistTrackDto>> getAll() {
//        List<PlaylistTrackDto> values = playlistTrackService.getAll();
//        return ResponseEntity.ok(values);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<PlaylistTrackDto> getById(@PathVariable("id") int id) {
//        PlaylistTrackDto value = playlistTrackService.getById(id);
//        return ResponseEntity.ok(value);
//    }
//
//    @PostMapping
//    public ResponseEntity<Void> add(@RequestBody PlaylistTrackDto entity) {
//        playlistTrackService.add(entity);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
//
//    @PutMapping
//    public ResponseEntity<Void> update(@RequestBody PlaylistTrackDto entity) {
//        playlistTrackService.update(entity);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
//        playlistTrackService.delete(id);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
//}
