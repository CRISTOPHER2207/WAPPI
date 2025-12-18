package com.wappi.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "reels")
@Data
public class Reel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String videoUrl; // Ruta al archivo de video

    private String description;

    private String fashionType; // Para agrupar reels por estilo también

    // RELACIÓN CLAVE: Un Reel tiene muchos Productos etiquetados
    @ManyToMany
    @JoinTable(
        name = "reel_products", // Tabla intermedia automática
        joinColumns = @JoinColumn(name = "reel_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> taggedProducts;
}