package com.example.Photolibrary.controllers;

import com.example.Photolibrary.models.Album;
import com.example.Photolibrary.models.Photo;
import com.example.Photolibrary.repos.AlbumRepo;
import com.example.Photolibrary.services.AlbumService;
import com.example.Photolibrary.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private PhotoService photoService;
    @GetMapping("/")
    public String redirect() {
        return "redirect:/albums";
    }
    @GetMapping("/albums")
    public String albums(Model model) {
        model.addAttribute("albums", albumService.getAllAlbums());
        return "albums";
    }
    @GetMapping("/albums/{id}")
    public String album(@PathVariable Long id, Model model) {
        model.addAttribute("album", albumService.getAlbumById(id));
        return "album";
    }
    @GetMapping("/albums/create")
    public String createAlbumPage() {
        return "createAlbum";
    }
    @PostMapping("/albums/create")
    public String createAlbum(@RequestParam("name") String name,
                              @RequestParam("photos") MultipartFile[] files) throws IOException {
        Album album = new Album(name);
        albumService.createAlbum(album);
            for (MultipartFile file : files) {
                    Photo photo = new Photo(file.getOriginalFilename(),
                            Base64.getEncoder().encodeToString(file.getBytes()));
                    photo.setAlbum(album);
                    photoService.save(photo);
            }
        return "redirect:/albums";
    }
    @PostMapping("/albums/{id}/delete")
    public String deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbum(id);
        return "redirect:/albums";
    }
}