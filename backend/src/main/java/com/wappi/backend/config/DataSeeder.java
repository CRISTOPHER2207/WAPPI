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
    
    // Tu servidor local
    private final String SERVER = "http://localhost:8080";

    public DataSeeder(ProductRepository productRepository, ReelRepository reelRepository) {
        this.productRepository = productRepository;
        this.reelRepository = reelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Limpiamos todo para empezar de cero
        reelRepository.deleteAll();
        productRepository.deleteAll();

        // 1. CREAR PRODUCTO 1 (Polo)
        Product p1 = new Product();
        p1.setName("Polo Oversize Graphic");
        p1.setDescription("Algodón 100%, estampado DTG de alta calidad.");
        p1.setPrice(55.00);
        p1.setCategory("SUPERIOR");
        p1.setFashionType("URBAN"); 
        p1.setSizes("S,M,L,XL");
        
        // AQUÍ ESTÁ LA CORRECCIÓN: Usamos los nuevos nombres
        p1.setDisplayImageUrl(SERVER + "/images/display/polo_model.jpg"); 
        p1.setTransparentImageUrl(SERVER + "/images/transparent/polo_png.png"); 

        // 2. CREAR PRODUCTO 2 (Pantalón)
        Product p2 = new Product();
        p2.setName("Cargo Pants Black");
        p2.setDescription("Pantalón táctico con cintas ajustables.");
        p2.setPrice(120.00);
        p2.setCategory("INFERIOR");
        p2.setFashionType("TECHWEAR");
        p2.setSizes("28,30,32,34");
        
        // CORRECCIÓN AQUÍ TAMBIÉN
        p2.setDisplayImageUrl(SERVER + "/images/display/pants_model.jpg");
        p2.setTransparentImageUrl(SERVER + "/images/transparent/pants_png.png");

        // Guardamos los productos
        List<Product> savedProducts = productRepository.saveAll(List.of(p1, p2));

        // 3. CREAR UN REEL (Opcional por ahora, pero bueno para la estructura)
        Reel r1 = new Reel();
        r1.setVideoUrl(SERVER + "/videos/video1.mp4");
        r1.setDescription("Outfit check para salir el viernes 🔥 #techwear");
        r1.setFashionType("URBAN");
        r1.setTaggedProducts(savedProducts); // Etiquetamos la ropa en el video

        reelRepository.save(r1);

        System.out.println("-------> ¡BASE DE DATOS ARREGLADA Y CARGADA! <-------");
    }
}