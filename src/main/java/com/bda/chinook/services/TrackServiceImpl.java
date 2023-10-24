package com.bda.chinook.services;

import com.bda.chinook.entities.Track;
import com.bda.chinook.entities.dto.TrackDto;
import com.bda.chinook.repositories.TrackRepository;
import com.bda.chinook.services.TrackService;
import com.bda.chinook.services.transformations.track.TrackDtoMapper;
import com.bda.chinook.services.transformations.track.TrackMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
@Service
public class TrackServiceImpl implements TrackService {
    private final TrackRepository trackRepository;
    private final TrackDtoMapper trackDtoMapper;
    private final TrackMapper trackMapper;

    public TrackServiceImpl(TrackRepository trackRepository, TrackDtoMapper trackDtoMapper, TrackMapper trackMapper) {
        this.trackRepository = trackRepository;
        this.trackDtoMapper = trackDtoMapper;
        this.trackMapper = trackMapper;
    }

    @Override
    public void add(TrackDto entity) {
        Track track = new Track();
        track.setName(entity.getName());
        track.setAlbumId(entity.getAlbumId());
        track.setMediaTypeId(entity.getMediaTypeId());
        track.setGenreId(entity.getGenreId());
        track.setComposer(entity.getComposer());
        track.setMilliseconds(entity.getMilliseconds());
        track.setBytes(entity.getBytes());
        track.setUnitPrice(entity.getUnitPrice());
        trackRepository.save(track);
    }

    @Override
    public TrackDto delete(Integer id) {
        Optional<Track> optionalTrack = trackRepository.findById(id);
        optionalTrack.ifPresent(trackRepository::delete);
        return optionalTrack
                .map(trackDtoMapper)
                .orElseThrow();
    }

    @Override
    public void update(TrackDto entity) {
        Optional<Track> optionalTrack = Stream.of(entity).map(trackMapper).findFirst();
        optionalTrack.ifPresent(trackRepository::save);
    }

    @Override
    public List<TrackDto> getAll() {
        List<Track> values = trackRepository.findAll();
        return values
                .stream()
                .map(trackDtoMapper)
                .toList();
    }

    @Override
    public TrackDto getById(Integer id) {
        Optional<Track> value = trackRepository.findById(id);
        return value
                .map(trackDtoMapper)
                .orElseThrow();
    }
}
