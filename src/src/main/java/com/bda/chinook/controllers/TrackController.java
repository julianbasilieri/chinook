package com.bda.chinook.controllers;

import com.bda.chinook.entities.dto.TrackDto;
import com.bda.chinook.services.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/track")
public class TrackController {
    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @GetMapping
    public ResponseEntity<List<TrackDto>> getAll() {
        List<TrackDto> values = trackService.getAll();
        return ResponseEntity.ok(values);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackDto> getById(@PathVariable("id") int id) {
        TrackDto value = trackService.getById(id);
        return ResponseEntity.ok(value);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody TrackDto entity) {
        trackService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody TrackDto entity) {
        trackService.update(entity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        trackService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
