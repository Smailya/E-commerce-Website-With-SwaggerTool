package com.example.E_comerce.Website;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ClothingRepository extends JpaRepository<Clothing, Long> {
    List<Clothing> findByNameContainingIgnoreCase(String name); // Corrected method name
}
