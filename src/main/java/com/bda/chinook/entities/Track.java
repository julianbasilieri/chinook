package com.bda.chinook.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tracks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Track {
    @Id
    @GeneratedValue(generator = "tracks")
    @TableGenerator(name = "tracks", table = "sqlite_sequence",
    pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "track_id")
    private int TrackId;
    private String Name;
    private int AlbumId;
    private int MediaTypeId;
    private int Genreid;
    private String Composer;
    private int Miliseconds;
    private int Bytes;
    private float UnitPrice;
}
