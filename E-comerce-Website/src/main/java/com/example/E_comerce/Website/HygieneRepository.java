package com.example.E_comerce.Website;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HygieneRepository extends JpaRepository<Hygiene, Long> {
    List<Hygiene> findByNameContainingIgnoreCase(String name); // Corrected method name
}