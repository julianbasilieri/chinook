package com.bda.chinook.services;

import com.bda.chinook.entities.Track;
import com.bda.chinook.entities.dto.TrackByGenreArtist;
import com.bda.chinook.entities.dto.TrackDto;
import com.bda.chinook.repositories.*;
import com.bda.chinook.services.transformations.track.TrackDtoMapper;
import com.bda.chinook.services.transformations.track.TrackMapper;
import com.bda.chinook.services.transformations.track.TrackToTrackByGenreArtist;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
@Service
public class TrackServiceImpl implements TrackService {
    private final TrackRepository trackRepository;
    private final TrackDtoMapper trackDtoMapper;
    private final TrackMapper trackMapper;
    private final TrackToTrackByGenreArtist trackToTrackByGenreArtist;
    private final AlbumRepository albumRepository;
    private final GenreRepository genreRepository;
    private final MediaTypeRepository mediaTypeRepository;
    public final ArtistRepostitory artistRepostitory;

    public TrackServiceImpl(TrackRepository trackRepository, TrackDtoMapper trackDtoMapper, TrackMapper trackMapper, TrackToTrackByGenreArtist trackToTrackByGenreArtist, AlbumRepository albumRepository, GenreRepository genreRepository, MediaTypeRepository mediaTypeRepository, ArtistRepostitory artistRepostitory) {
        this.trackRepository = trackRepository;
        this.trackDtoMapper = trackDtoMapper;
        this.trackMapper = trackMapper;
        this.trackToTrackByGenreArtist = trackToTrackByGenreArtist;
        this.albumRepository = albumRepository;
        this.genreRepository = genreRepository;
        this.mediaTypeRepository = mediaTypeRepository;
        this.artistRepostitory = artistRepostitory;
    }

    @Override
    public void add(TrackDto entity) {
        Track track = new Track();
        track.setName(entity.getName());
        albumRepository.getReferenceById(entity.getAlbumId());
        mediaTypeRepository.getReferenceById(entity.getMediaTypeId());
        genreRepository.getReferenceById(entity.getGenreId());
        track.setComposer(entity.getComposer());
        track.setMilliseconds(entity.getMilliseconds());
        track.setBytes(entity.getBytes());
        track.setUnitPrice(entity.getUnitPrice());
        track.setInvoiceItems(new ArrayList<>());
        track.setPlaylists(new ArrayList<>());
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

    @Override
    public List<TrackByGenreArtist> getAllByGenreArtist(Integer genreId, Integer artistId) {
        List<Track> tracks = trackRepository.findByAlbum_ArtistArtistIdAndGenreGenreId(artistId, genreId);
        return tracks
                .stream()
                .map(trackToTrackByGenreArtist)
                .toList();
    }
}
