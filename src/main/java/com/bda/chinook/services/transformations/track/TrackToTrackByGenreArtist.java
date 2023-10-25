package com.bda.chinook.services.transformations.track;

import com.bda.chinook.entities.Track;
import com.bda.chinook.entities.TrackByGenreArtist;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class TrackToTrackByGenreArtist implements Function<Track, TrackByGenreArtist> {
    @Override
    public TrackByGenreArtist apply(Track track) {
        return new TrackByGenreArtist(track.getTrackId(),
                track.getName(),
                track.getGenre().getName(),
                track.getAlbum().getArtist().getName(),
                track.getComposer());
    }
}
