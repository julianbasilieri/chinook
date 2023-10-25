//package com.bda.chinook.services;
//
//import com.bda.chinook.entities.PlaylistTrack;
//import com.bda.chinook.entities.dto.PlaylistTrackDto;
//import com.bda.chinook.repositories.PlaylistRepository;
//import com.bda.chinook.repositories.PlaylistTrackRepository;
//import com.bda.chinook.repositories.TrackRepository;
//import com.bda.chinook.services.transformations.playlistTrack.PlaylistTrackDtoMapper;
//import com.bda.chinook.services.transformations.playlistTrack.PlaylistTrackMapper;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Stream;
//@Service
//public class PlaylistTrackServiceImpl implements PlaylistTrackService {
//    private final PlaylistTrackRepository playlistTrackRepository;
//    private final PlaylistTrackDtoMapper playlistTrackDtoMapper;
//    private final PlaylistTrackMapper playlistTrackMapper;
//    public final PlaylistRepository playlistRepository;
//    public final TrackRepository trackRepository;
//
//    public PlaylistTrackServiceImpl(PlaylistTrackRepository playlistTrackRepository, PlaylistTrackDtoMapper playlistTrackDtoMapper, PlaylistTrackMapper playlistTrackMapper, PlaylistRepository playlistRepository, TrackRepository trackRepository) {
//        this.playlistTrackRepository = playlistTrackRepository;
//        this.playlistTrackDtoMapper = playlistTrackDtoMapper;
//        this.playlistTrackMapper = playlistTrackMapper;
//        this.playlistRepository = playlistRepository;
//        this.trackRepository = trackRepository;
//    }
//
//    @Override
//    public void add(PlaylistTrackDto entity) {
//        PlaylistTrack playlistTrack = new PlaylistTrack();
//        playlistTrack.setPlaylist(playlistRepository.getReferenceById(entity.getPlaylistId()));
//        playlistTrack.setTrack(trackRepository.getReferenceById(entity.getTrackId()));
//        playlistTrackRepository.save(playlistTrack);
//    }
//
//    @Override
//    public PlaylistTrackDto delete(Integer id) {
//        Optional<PlaylistTrack> optionalPlaylistTrack = playlistTrackRepository.findById(id);
//        optionalPlaylistTrack.ifPresent(playlistTrackRepository::delete);
//        return optionalPlaylistTrack
//                .map(playlistTrackDtoMapper)
//                .orElseThrow();
//    }
//
//    @Override
//    public void update(PlaylistTrackDto entity) {
//        Optional<PlaylistTrack> optionalPlaylistTrack = Stream.of(entity).map(playlistTrackMapper).findFirst();
//        optionalPlaylistTrack.ifPresent(playlistTrackRepository::save);
//    }
//
//    @Override
//    public List<PlaylistTrackDto> getAll() {
//        List<PlaylistTrack> values = playlistTrackRepository.findAll();
//        return values
//                .stream()
//                .map(playlistTrackDtoMapper)
//                .toList();
//    }
//
//    @Override
//    public PlaylistTrackDto getById(Integer id) {
//        Optional<PlaylistTrack> value = playlistTrackRepository.findById(id);
//        return value
//                .map(playlistTrackDtoMapper)
//                .orElseThrow();
//    }
//}
