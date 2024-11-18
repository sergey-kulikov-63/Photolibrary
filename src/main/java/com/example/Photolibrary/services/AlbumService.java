package com.example.Photolibrary.services;

import com.example.Photolibrary.models.Album;
import com.example.Photolibrary.repos.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepo albumRepo;

    public List<Album> getAllAlbums() {
        return albumRepo.findAll();
    }
    public Album getAlbumById(Long id) {
        return albumRepo.findById(id).orElseThrow();
    }

    public Album createAlbum(Album album) {
        return albumRepo.save(album);
    }

    public void deleteAlbum(Long id) {
        albumRepo.deleteById(id);
    }
}