package com.wappi.backend.repository;

import com.wappi.backend.entity.Reel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReelRepository extends JpaRepository<Reel, Long> {
    // Aquí podremos buscar reels por estilo luego
}