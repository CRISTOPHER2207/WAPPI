package com.wappi.backend.controller;

import com.wappi.backend.entity.Reel;
import com.wappi.backend.repository.ReelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // Importa todo esto

import java.util.List;

@RestController
@RequestMapping("/api/reels")
@CrossOrigin(origins = "http://localhost:4200") // <--- ¡ESTA LÍNEA ES LA CLAVE!
public class ReelController {

    @Autowired
    private ReelRepository reelRepository;

    @GetMapping
    public List<Reel> getAllReels() {
        return reelRepository.findAll();
    }
}