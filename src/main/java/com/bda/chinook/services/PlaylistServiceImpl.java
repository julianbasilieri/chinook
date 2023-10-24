package com.bda.chinook.services;

import com.bda.chinook.entities.Playlist;
import com.bda.chinook.entities.dto.PlaylistDto;
import com.bda.chinook.repositories.PlaylistRepository;
import com.bda.chinook.services.transformations.playlist.PlaylistDtoMapper;
import com.bda.chinook.services.transformations.playlist.PlaylistMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
@Service
public class PlaylistServiceImpl implements PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final PlaylistDtoMapper playlistDtoMapper;
    private final PlaylistMapper playlistMapper;

    public PlaylistServiceImpl(PlaylistRepository playlistRepository, PlaylistDtoMapper playlistDtoMapper, PlaylistMapper playlistMapper) {
        this.playlistRepository = playlistRepository;
        this.playlistDtoMapper = playlistDtoMapper;
        this.playlistMapper = playlistMapper;
    }

    @Override
    public void add(PlaylistDto entity) {
        Playlist playlist = Optional.of(entity).map(playlistMapper).orElseThrow();
        playlistRepository.save(playlist);
    }

    @Override
    public PlaylistDto delete(Integer id) {
        Optional<Playlist> optionalPlaylist = playlistRepository.findById(id);
        optionalPlaylist.ifPresent(playlistRepository::delete);
        return optionalPlaylist
                .map(playlistDtoMapper)
                .orElseThrow();
    }

    @Override
    public void update(PlaylistDto entity) {
        Optional<Playlist> optionalPlaylist = Stream.of(entity).map(playlistMapper).findFirst();
        optionalPlaylist.ifPresent(playlistRepository::save);
    }

    @Override
    public List<PlaylistDto> getAll() {
        List<Playlist> values = playlistRepository.findAll();
        return values
                .stream()
                .map(playlistDtoMapper)
                .toList();
    }

    @Override
    public PlaylistDto getById(Integer id) {
        Optional<Playlist> value = playlistRepository.findById(id);
        return value
                .map(playlistDtoMapper)
                .orElseThrow();
    }
}
