package com.example.E_comerce.Website;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping; // Import GetMapping
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/hygiene") // Base URL for this controller
public class HygieneController {

    @Autowired
    private HygieneRepository hygieneRepository; // Use private access modifier

    @GetMapping // Handles GET requests to /hygiene
    public List<Hygiene> getAllHygiene() {
        return hygieneRepository.findAll();
    }

    @PostMapping("/create") // Handles POST requests to /hygiene/create
    public Hygiene createHygiene(@RequestBody Hygiene hygiene) {
        return hygieneRepository.save(hygiene);
    }
    
    // Update an existing hygiene item
    @PutMapping("/update/{id}")
    public ResponseEntity<Hygiene> updateHygiene(@PathVariable Long id, @RequestBody Hygiene updatedHygiene) {
        return hygieneRepository.findById(id)
            .map(hygiene -> {
                hygiene.setName(updatedHygiene.getName());
                hygiene.setPrice(updatedHygiene.getPrice());
                hygiene.setDescription(updatedHygiene.getDescription());
                return ResponseEntity.ok(hygieneRepository.save(hygiene));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    // Delete a hygiene item by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteHygiene(@PathVariable Long id) {
        return hygieneRepository.findById(id)
            .map(hygiene -> {
                hygieneRepository.delete(hygiene);
                return ResponseEntity.ok().build();
            })
            .orElse(ResponseEntity.notFound().build());
    }
}
