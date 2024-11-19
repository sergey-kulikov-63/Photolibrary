package com.example.Photolibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class PhotolibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotolibraryApplication.class, args);
	}

}
