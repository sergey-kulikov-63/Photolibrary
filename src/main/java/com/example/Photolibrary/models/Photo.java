package com.example.Photolibrary.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photoname;
    @Column(columnDefinition = "TEXT")
    private String imageData;
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    public Photo(String photoname, String imageData) {
        this.photoname = photoname;
        this.imageData = imageData;
    }

    public Photo() {
    }
}