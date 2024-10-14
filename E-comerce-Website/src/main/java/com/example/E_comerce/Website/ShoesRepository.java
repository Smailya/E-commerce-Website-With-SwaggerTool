package com.example.E_comerce.Website;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoesRepository extends JpaRepository<Shoes, Long> {
    List<Shoes> findByNameContainingIgnoreCase(String name); // Corrected method name
}
