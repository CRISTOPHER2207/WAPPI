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

    // Tu URL de Supabase (Asegúrate que el bucket sea PUBLICO)
    private final String BUCKET = "https://wajmjudpzatpimyridep.supabase.co/storage/v1/object/public/wappi-content";

    public DataSeeder(ProductRepository productRepository, ReelRepository reelRepository) {
        this.productRepository = productRepository;
        this.reelRepository = reelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Borramos datos viejos para no repetir
        reelRepository.deleteAll();
        productRepository.deleteAll();

        // --- 1. LAS PRENDAS (En carpeta images) ---
        Product p1 = new Product();
        p1.setName("Wappi Oversize Tee");
        p1.setPrice(45.00);
        p1.setSizes("S,M,L");
        p1.setDisplayImageUrl(BUCKET + "/images/d1.png"); 
        p1.setTransparentImageUrl(BUCKET + "/images/t1.png"); 
        // Llenamos datos mínimos obligatorios
        p1.setDescription("Polo básico"); p1.setCategory("SUPERIOR"); p1.setFashionType("URBAN");

        Product p2 = new Product();
        p2.setName("Cargo Pants Black");
        p2.setPrice(99.90);
        p2.setSizes("30,32,34");
        p2.setDisplayImageUrl(BUCKET + "/images/d2.png");
        p2.setTransparentImageUrl(BUCKET + "/images/t2.png");
        p2.setDescription("Pantalón cargo"); p2.setCategory("INFERIOR"); p2.setFashionType("URBAN");

        List<Product> ropas = productRepository.saveAll(List.of(p1, p2));

        // --- 2. EL VIDEO (En carpeta videos) ---
        Reel r1 = new Reel();
        r1.setDescription("Outfit urbano 2025 🔥");
        r1.setFashionType("URBAN");
        r1.setVideoUrl(BUCKET + "/videos/reel1.mp4"); // <--- AQUÍ CARGA EL VIDEO

        // --- 3. VINCULACIÓN ---
        r1.setTaggedProducts(ropas); // <--- AQUÍ SE UNEN AL VIDEO

        reelRepository.save(r1);

        System.out.println("✅ ¡LISTO! Video de Supabase cargado y vinculado.");
    }
}