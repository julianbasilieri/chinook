package com.bda.chinook.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "albums")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "albums", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "albums_id")
    private int AlbumId;
    @ManyToOne
    @JoinColumn(name = "ArtistId")
    private Artist artist;
    private String Title;
    @OneToMany(mappedBy = "album")
    private List<Track> tracks;
}
