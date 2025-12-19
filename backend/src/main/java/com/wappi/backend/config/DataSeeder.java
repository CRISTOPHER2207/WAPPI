package com.wappi.backend.config;

import com.wappi.backend.entity.Product;
import com.wappi.backend.entity.Reel;
import com.wappi.backend.repository.ProductRepository;
import com.wappi.backend.repository.ReelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final ReelRepository reelRepository;
    
    // Tu servidor local (Asegúrate de que Spring Boot corra en el puerto 8080)
    private final String SERVER = "http://localhost:8080";

    public DataSeeder(ProductRepository productRepository, ReelRepository reelRepository) {
        this.productRepository = productRepository;
        this.reelRepository = reelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // 1. Limpiamos la base de datos previa para evitar duplicados
        reelRepository.deleteAll();
        productRepository.deleteAll();

        // -----------------------------------------------------------
        // 2. CREAR PRODUCTOS
        // -----------------------------------------------------------

        // Producto 1: Polo
        Product p1 = new Product();
        p1.setName("Polo Oversize Graphic");
        p1.setDescription("Algodón 100%, estampado DTG de alta calidad.");
        p1.setPrice(55.00);
        p1.setCategory("SUPERIOR");
        p1.setFashionType("URBAN"); 
        p1.setSizes("S,M,L,XL");
        
        // Apuntamos a las imágenes que SÍ existen en tu carpeta static/images
        p1.setDisplayImageUrl(SERVER + "/images/display/d1.png"); 
        p1.setTransparentImageUrl(SERVER + "/images/transparent/t1.png"); 

        // Producto 2: Pantalón
        Product p2 = new Product();
        p2.setName("Cargo Pants Black");
        p2.setDescription("Pantalón táctico con cintas ajustables.");
        p2.setPrice(120.00);
        p2.setCategory("INFERIOR");
        p2.setFashionType("TECHWEAR");
        p2.setSizes("28,30,32,34");
        
        p2.setDisplayImageUrl(SERVER + "/images/display/d2.png");
        p2.setTransparentImageUrl(SERVER + "/images/transparent/t2.png");

        // Guardamos los productos en la base de datos
        List<Product> savedProducts = productRepository.saveAll(List.of(p1, p2));

        // -----------------------------------------------------------
        // 3. CREAR REEL (TIKTOK SECTION)
        // -----------------------------------------------------------
        Reel r1 = new Reel();
        
        // CORRECCIÓN CLAVE: Usamos la URL completa para que Angular lo encuentre
        r1.setVideoUrl(SERVER + "/videos/reel1.mp4"); 
        
        r1.setDescription("Outfit check para salir el viernes 🔥 #techwear");
        r1.setFashionType("URBAN");
        
        // Etiquetamos los productos que creamos arriba
        r1.setTaggedProducts(savedProducts); 

        // Guardamos el Reel
        reelRepository.save(r1);

        System.out.println("-------> ¡BASE DE DATOS ARREGLADA Y CARGADA CORRECTAMENTE! <-------");
    }
}