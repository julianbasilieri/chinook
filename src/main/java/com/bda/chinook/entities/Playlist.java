package com.bda.chinook.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "playlists")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Playlist {
    @Id
    @GeneratedValue(generator = "playlists")
    @TableGenerator(name = "playlists", table = "sqlite_sequence",
    pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "playlist_id")
    private int PlaylistId;
    private String Name;
}
