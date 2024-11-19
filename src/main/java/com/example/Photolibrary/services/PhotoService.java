package com.example.Photolibrary.services;

import com.example.Photolibrary.models.Photo;
import com.example.Photolibrary.repos.PhotoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {
    @Autowired
    private PhotoRepo photoRepo;
    @Async
    public void save(Photo photo) {
        photoRepo.save(photo);
    }
}