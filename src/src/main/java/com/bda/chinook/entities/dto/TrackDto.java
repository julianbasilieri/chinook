package com.bda.chinook.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackDto {
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
