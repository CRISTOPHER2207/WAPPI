package com.wappi.backend.repository;

import com.wappi.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // ¡Listo! Al extender de JpaRepository, Spring ya sabe cómo
    // hacer SELECT, INSERT, DELETE y UPDATE automáticamente.
}