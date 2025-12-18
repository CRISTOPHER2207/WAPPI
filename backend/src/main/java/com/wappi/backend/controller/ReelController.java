package com.wappi.backend.controller;

import com.wappi.backend.entity.Reel;
import com.wappi.backend.repository.ReelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reels")
@CrossOrigin(origins = "*")
public class ReelController {

    @Autowired
    private ReelRepository reelRepository;

    @GetMapping
    public List<Reel> getAllReels() {
        // Esto devolverá el video Y la lista de productos etiquetados dentro
        return reelRepository.findAll();
    }
}