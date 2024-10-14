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
@RequestMapping("/clothing") // Base URL for this controller
public class ClothingController {

    @Autowired
    private ClothingRepository clothingRepository; // Use private access modifier

    @GetMapping // Handles GET requests to /clothing
    public List<Clothing> getAllClothing() {
        return clothingRepository.findAll();
    }

    @PostMapping("/create") // Handles POST requests to /clothing/create
    public Clothing createClothing(@RequestBody Clothing clothing) {
        return clothingRepository.save(clothing);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Clothing> updateClothing(@PathVariable Long id, @RequestBody Clothing updatedClothing) {
        return clothingRepository.findById(id)
            .map(clothing -> {
                clothing.setName(updatedClothing.getName());
                clothing.setPrice(updatedClothing.getPrice());
                clothing.setDescription(updatedClothing.getDescription());
                return ResponseEntity.ok(clothingRepository.save(clothing));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    // Delete a clothing item by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteClothing(@PathVariable Long id) {
        return clothingRepository.findById(id)
            .map(clothing -> {
                clothingRepository.delete(clothing);
                return ResponseEntity.ok().build();
            })
            .orElse(ResponseEntity.notFound().build());
    }
}
