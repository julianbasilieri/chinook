package com.bda.chinook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tracks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "tracks", table = "sqlite_sequence",
    pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "track_id")
    private int TrackId;
    private String Name;
    @ManyToOne
    @JoinColumn(name = "AlbumId")
    private Album album;
    @ManyToOne
    @JoinColumn(name = "MediaTypeId")
    private MediaType mediaType;
    @ManyToOne
    @JoinColumn(name = "GenreId")
    private Genre genre;
    private String Composer;
    private int Milliseconds;
    private int Bytes;
    private float UnitPrice;
    @OneToMany(mappedBy = "track")
    List<InvoiceItems> invoiceItems;
}
