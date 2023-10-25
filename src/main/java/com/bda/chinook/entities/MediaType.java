package com.bda.chinook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "media_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "media_types", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "media_type_id")
    private int MediaTypeId;
    private String Name;
    @OneToMany(mappedBy = "mediaType")
    private List<Track> tracks;
}
