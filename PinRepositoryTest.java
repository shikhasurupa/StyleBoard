package org.example.styleboard;


import org.example.styleboard.model.Pin;
import org.example.styleboard.model.User;
import org.example.styleboard.repository.PinRepository;
import org.example.styleboard.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@DataJpaTest
public class PinRepositoryTest {

    @Autowired
    private PinRepository pinRepository;

    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("testuser", "password", "testuser@example.com");
        user = userRepository.save(user);

        Pin pin1 = new Pin();
        pin1.setTitle("Test Pin 1");
        pin1.setDescription("Description 1");
        pin1.setImageUrl("http://example.com/image1.png");
        pin1.setUser(user);

        Pin pin2 = new Pin();
        pin2.setTitle("Test Pin 2");
        pin2.setDescription("Description 2");
        pin2.setImageUrl("http://example.com/image2.png");
        pin2.setUser(user);

        pinRepository.save(pin1);
        pinRepository.save(pin2);
    }

    @Test
    void testFindByUserId() {
        List<Pin> pins = pinRepository.findByUserId(user.getId());
        assertThat(pins).hasSize(2);
    }

    @Test
    void testFindAll() {
        List<Pin> pins = pinRepository.findAll();
        assertThat(pins).hasSize(2);
    }
}