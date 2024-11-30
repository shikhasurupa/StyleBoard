package org.example.styleboard;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.example.styleboard.model.Pin;
import org.example.styleboard.model.User;
import org.example.styleboard.repository.PinRepository;
import org.example.styleboard.repository.UserRepository;
import org.example.styleboard.service.PinService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PinServiceTest {

    @Mock
    private PinRepository pinRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private PinService pinService;

    private User user;
    private Pin pin;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User("testuser", "password", "testuser@example.com");
        user.setId(1L);

        pin = new Pin();
        pin.setId(1L);
        pin.setTitle("Test Pin");
        pin.setDescription("Test Description");
        pin.setImageUrl("http://example.com/image.png");
        pin.setUser(user);
    }

    @Test
    void createPin_shouldReturnSavedPin() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(pinRepository.save(pin)).thenReturn(pin);

        Pin savedPin = pinService.createPin(pin, 1L);

        assertThat(savedPin).isNotNull();
        assertThat(savedPin.getUser()).isEqualTo(user);
        verify(pinRepository, times(1)).save(pin);
    }

    @Test
    void getAllPins_shouldReturnListOfPins() {
        when(pinRepository.findAll()).thenReturn(List.of(pin));

        List<Pin> pins = pinService.getAllPins();

        assertThat(pins).hasSize(1);
        verify(pinRepository, times(1)).findAll();
    }

    @Test
    void getPinById_shouldReturnPin() {
        when(pinRepository.findById(1L)).thenReturn(Optional.of(pin));

        Optional<Pin> foundPin = pinService.getPinById(1L);

        assertThat(foundPin).isPresent();
        assertThat(foundPin.get().getTitle()).isEqualTo("Test Pin");
    }

    @Test
    void deletePin_shouldRemovePin() {
        doNothing().when(pinRepository).deleteById(1L);

        pinService.deletePin(1L);

        verify(pinRepository, times(1)).deleteById(1L);
    }

    @Test
    void getPinsByUserId_shouldReturnPins() {
        when(pinRepository.findByUserId(1L)).thenReturn(List.of(pin));

        List<Pin> pins = pinService.getPinsByUserId(1L);

        assertThat(pins).hasSize(1);
    }
}