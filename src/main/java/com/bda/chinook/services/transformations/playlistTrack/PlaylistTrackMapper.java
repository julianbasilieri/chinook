//package com.bda.chinook.services.transformations.playlistTrack;
//
//import com.bda.chinook.entities.PlaylistTrack;
//import com.bda.chinook.entities.dto.PlaylistTrackDto;
//import com.bda.chinook.repositories.PlaylistRepository;
//import com.bda.chinook.repositories.TrackRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.function.Function;
//
//@Service
//public class PlaylistTrackMapper implements Function<PlaylistTrackDto, PlaylistTrack> {
//    public final PlaylistRepository playlistRepository;
//    public final TrackRepository trackRepository;
//
//    public PlaylistTrackMapper(PlaylistRepository playlistRepository, TrackRepository trackRepository) {
//        this.playlistRepository = playlistRepository;
//        this.trackRepository = trackRepository;
//    }
//
//    @Override
//    public PlaylistTrack apply(PlaylistTrackDto playlistTrackDto) {
//        return new PlaylistTrack(playlistRepository.getReferenceById(playlistTrackDto.getPlaylistId()),
//                trackRepository.getReferenceById(playlistTrackDto.getTrackId()));
//    }
//}
