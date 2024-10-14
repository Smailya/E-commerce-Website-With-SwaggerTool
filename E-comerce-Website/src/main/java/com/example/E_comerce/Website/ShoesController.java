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
@RequestMapping("/shoes") // Base URL for this controller
public class ShoesController {

    @Autowired
    private ShoesRepository shoesRepository; // Use private access modifier

    @GetMapping // Handles GET requests to /shoes
    public List<Shoes> getAllShoes() {
        return shoesRepository.findAll();
    }

    @PostMapping("/create") // Handles POST requests to /shoes/create
    public Shoes createShoes(@RequestBody Shoes shoes) {
        return shoesRepository.save(shoes);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Shoes> updateShoes(@PathVariable Long id, @RequestBody Shoes updatedShoes) {
        return shoesRepository.findById(id)
            .map(shoes -> {
                shoes.setId(updatedShoes.getId());
                shoes.setPrice(updatedShoes.getPrice());
                shoes.setDescription(updatedShoes.getDescription());
                return ResponseEntity.ok(shoesRepository.save(shoes));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    // Delete a shoes item by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteShoes(@PathVariable Long id) {
        return shoesRepository.findById(id)
            .map(shoes -> {
                shoesRepository.delete(shoes);
                return ResponseEntity.ok().build();
            })
            .orElse(ResponseEntity.notFound().build());
    }
}
