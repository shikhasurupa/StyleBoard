package org.example.styleboard.controllers;


import org.example.styleboard.model.Pin;
import org.example.styleboard.service.PinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pins")
public class PinController {

    private final PinService pinService;

    @Autowired
    public PinController(PinService pinService) {
        this.pinService = pinService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Pin> createPin(@RequestBody Pin pin, @PathVariable Long userId) {
        return ResponseEntity.ok(pinService.createPin(pin, userId));
    }

    @GetMapping
    public ResponseEntity<List<Pin>> getAllPins() {
        return ResponseEntity.ok(pinService.getAllPins());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pin> getPinById(@PathVariable Long id) {
        return pinService.getPinById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePin(@PathVariable Long id) {
        pinService.deletePin(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Pin>> getPinsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(pinService.getPinsByUserId(userId));
    }
}