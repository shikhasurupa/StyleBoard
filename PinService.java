package org.example.styleboard.service;
import org.example.styleboard.model.Pin;
import org.example.styleboard.model.User;
import org.example.styleboard.repository.PinRepository;
import org.example.styleboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PinService {

    private final PinRepository pinRepository;
    private final UserRepository userRepository;

    @Autowired
    public PinService(PinRepository pinRepository, UserRepository userRepository) {
        this.pinRepository = pinRepository;
        this.userRepository = userRepository;
    }

    public Pin createPin(Pin pin, Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        pin.setUser(user);
        return pinRepository.save(pin);
    }

    public List<Pin> getAllPins() {
        return pinRepository.findAll();
    }

    public Optional<Pin> getPinById(Long id) {
        return pinRepository.findById(id);
    }

    public void deletePin(Long id) {
        pinRepository.deleteById(id);
    }

    public List<Pin> getPinsByUserId(Long userId) {
        return pinRepository.findByUserId(userId);
    }
}