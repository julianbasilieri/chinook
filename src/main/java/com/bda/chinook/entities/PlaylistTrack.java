//package com.bda.chinook.entities;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Table(name = "playlist_track")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class PlaylistTrack {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @TableGenerator(name = "playlist_track", table = "sqlite_sequence",
//            pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "playlist_track_id")
//
//    @ManyToOne
//    @MapsId("playlistId")
//    @JoinColumn(name = "PlaylistId")
//    private Playlist playlist;
//
//    @ManyToOne
//    @MapsId("trackId")
//    @JoinColumn(name = "TrackId")
//    private Track track;
//}
