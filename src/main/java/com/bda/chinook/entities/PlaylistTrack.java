package com.bda.chinook.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "playlist_track")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistTrack {
    @Id
    @GeneratedValue(generator = "playlist_track")
    @TableGenerator(name = "playlist_track", table = "sqlite_sequence",
    pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "playlist_track_id")
    private int PlaylistId;
    private int TrackId;
}
