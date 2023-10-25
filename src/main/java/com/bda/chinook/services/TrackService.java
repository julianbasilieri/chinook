package com.bda.chinook.services;

import com.bda.chinook.entities.Track;
import com.bda.chinook.entities.TrackByGenreArtist;
import com.bda.chinook.entities.dto.PlaylistDto;
import com.bda.chinook.entities.dto.TrackDto;

import java.util.List;

public interface TrackService extends Service<TrackDto, Integer> {
    List<TrackByGenreArtist> getAllByGenreArtist(Integer genreId, Integer artistId);
}
