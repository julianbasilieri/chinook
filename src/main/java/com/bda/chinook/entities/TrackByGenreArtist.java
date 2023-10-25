package com.bda.chinook.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackByGenreArtist {
    private int TrackId;
    private String Name;
    private String NameGenre;
    private String NameArtist;
    private String Composer;
}
