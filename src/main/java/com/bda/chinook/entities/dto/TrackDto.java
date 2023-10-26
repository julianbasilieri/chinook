package com.bda.chinook.entities.dto;

import com.bda.chinook.entities.InvoiceItems;
import com.bda.chinook.entities.Playlist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackDto {
    private int TrackId;
    private String Name;
    private int AlbumId;
    private int MediaTypeId;
    private int GenreId;
    private String Composer;
    private int Milliseconds;
    private int Bytes;
    private float UnitPrice;
    List<InvoiceItems> invoiceItems;
    private List<Playlist> playlists;
}
