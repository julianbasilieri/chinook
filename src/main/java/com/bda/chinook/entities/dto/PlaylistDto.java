package com.bda.chinook.entities.dto;

import com.bda.chinook.entities.Track;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistDto {
    private int PlaylistId;
    private String Name;
    private List<Track> tracks;
}
