package com.example.Photolibrary.repos;

import com.example.Photolibrary.models.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepo extends JpaRepository<Photo, Long> {
}
