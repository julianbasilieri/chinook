package com.bda.chinook.repositories;

import com.bda.chinook.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepostitory extends JpaRepository<Artist, Integer> {
}
