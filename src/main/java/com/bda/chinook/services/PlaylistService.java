package com.bda.chinook.services;

import com.bda.chinook.entities.Track;
import com.bda.chinook.entities.dto.PlaylistDto;

import java.util.List;

public interface PlaylistService extends Service<PlaylistDto, Integer> {
    List<Track> getTracksInPlaylist(int playlistId);
}
