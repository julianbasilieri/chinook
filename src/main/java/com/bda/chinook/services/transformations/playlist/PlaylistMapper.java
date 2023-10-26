package com.bda.chinook.services.transformations.playlist;

import com.bda.chinook.entities.Playlist;
import com.bda.chinook.entities.dto.PlaylistDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PlaylistMapper implements Function<PlaylistDto, Playlist> {
    @Override
    public Playlist apply(PlaylistDto playlistDto) {
        return new Playlist(playlistDto.getPlaylistId(),
                playlistDto.getName(),
                playlistDto.getTracks());
    }
}
