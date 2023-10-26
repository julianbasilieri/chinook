package com.bda.chinook.repositories;

import com.bda.chinook.entities.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {
    List<Track> findByAlbum_ArtistArtistIdAndGenreGenreId(Integer artistId, Integer genreId);

}
