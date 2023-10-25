//package com.bda.chinook.services.transformations.playlistTrack;
//
//import com.bda.chinook.entities.PlaylistTrack;
//import com.bda.chinook.entities.dto.PlaylistTrackDto;
//import org.springframework.stereotype.Service;
//
//import java.util.function.Function;
//
//@Service
//public class PlaylistTrackDtoMapper implements Function<PlaylistTrack, PlaylistTrackDto> {
//    @Override
//    public PlaylistTrackDto apply(PlaylistTrack playlistTrack) {
//        return new PlaylistTrackDto(playlistTrack.getPlaylist().getPlaylistId(),
//                playlistTrack.getTrack().getTrackId());
//    }
//}
