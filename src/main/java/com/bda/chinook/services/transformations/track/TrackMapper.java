package com.bda.chinook.services.transformations.track;

import com.bda.chinook.entities.Track;
import com.bda.chinook.entities.dto.TrackDto;
import com.bda.chinook.repositories.AlbumRepository;
import com.bda.chinook.repositories.GenreRepository;
import com.bda.chinook.repositories.MediaTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.function.Function;
@Service
public class TrackMapper implements Function<TrackDto, Track> {
    private final AlbumRepository albumRepository;
    private final GenreRepository genreRepository;
    private final MediaTypeRepository mediaTypeRepository;

    public TrackMapper(AlbumRepository albumRepository, GenreRepository genreRepository, MediaTypeRepository mediaTypeRepository) {
        this.albumRepository = albumRepository;
        this.genreRepository = genreRepository;
        this.mediaTypeRepository = mediaTypeRepository;
    }

    @Override
    public Track apply(TrackDto trackDto) {
        return new Track(trackDto.getTrackId(),
                trackDto.getName(),
                albumRepository.getReferenceById(trackDto.getAlbumId()),
                mediaTypeRepository.getReferenceById(trackDto.getMediaTypeId()),
                genreRepository.getReferenceById(trackDto.getGenreId()),
                trackDto.getComposer(),
                trackDto.getMilliseconds(),
                trackDto.getBytes(),
                trackDto.getUnitPrice(),
                new ArrayList<>());
    }
}
