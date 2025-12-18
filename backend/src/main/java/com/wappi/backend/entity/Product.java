package com.wappi.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    @Column(length = 1000) 
    private String description;

    private Double price;

    // YA NO USAMOS imageUrl. Usamos estos dos:
    private String displayImageUrl;       // Foto para la tienda (con modelo)
    private String transparentImageUrl;   // Foto para el probador (PNG sin fondo)

    private String fashionType; // "URBAN", "TECHWEAR", etc.

    private String sizes; // "S,M,L"

    private String category; // "SUPERIOR", "INFERIOR", "CALZADO"
}