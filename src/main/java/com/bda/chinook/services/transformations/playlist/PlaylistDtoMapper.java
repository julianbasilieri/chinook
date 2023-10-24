package com.bda.chinook.services.transformations.playlist;

import com.bda.chinook.entities.Playlist;
import com.bda.chinook.entities.dto.PlaylistDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PlaylistDtoMapper implements Function<Playlist, PlaylistDto> {
    @Override
    public PlaylistDto apply(Playlist playlist) {
        return new PlaylistDto(playlist.getPlaylistId(),
                playlist.getName());
    }
}
