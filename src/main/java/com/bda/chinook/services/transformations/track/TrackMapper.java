package com.bda.chinook.services.transformations.track;

import com.bda.chinook.entities.Track;
import com.bda.chinook.entities.dto.TrackDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class TrackMapper implements Function<TrackDto, Track> {
    @Override
    public Track apply(TrackDto trackDto) {
        return new Track(trackDto.getTrackId(),
                trackDto.getName(),
                trackDto.getAlbumId(),
                trackDto.getMediaTypeId(),
                trackDto.getGenreId(),
                trackDto.getComposer(),
                trackDto.getMilliseconds(),
                trackDto.getBytes(),
                trackDto.getUnitPrice());
    }
}
