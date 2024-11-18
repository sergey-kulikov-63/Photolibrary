package com.example.Photolibrary.controllers;

import com.example.Photolibrary.services.AlbumService;
import com.example.Photolibrary.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private PhotoService photoService;
}
