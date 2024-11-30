package org.example.styleboard;

import org.example.styleboard.controllers.PinController;
import org.example.styleboard.model.Pin;
import org.example.styleboard.service.PinService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PinController.class)
class PinControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PinService pinService;

    @Autowired
    private ObjectMapper objectMapper;

    private Pin pin;

    @BeforeEach
    void setUp() {
        pin = new Pin();
        pin.setId(1L);
        pin.setTitle("Test Pin");
        pin.setDescription("Test Description");
        pin.setImageUrl("http://example.com/image.png");
    }

    @Test
    void createPin_shouldReturnCreatedPin() throws Exception {
        when(pinService.createPin(any(Pin.class), eq(1L))).thenReturn(pin);

        mockMvc.perform(post("/api/pins/1")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(pin)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.title").value("Test Pin"));

        verify(pinService, times(1)).createPin(any(Pin.class), eq(1L));
    }

    @Test
    void getAllPins_shouldReturnListOfPins() throws Exception {
        when(pinService.getAllPins()).thenReturn(List.of(pin));

        mockMvc.perform(get("/api/pins"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.size()").value(1));

        verify(pinService, times(1)).getAllPins();
    }

    @Test
    void getPinById_shouldReturnPin() throws Exception {
        when(pinService.getPinById(1L)).thenReturn(Optional.of(pin));

        mockMvc.perform(get("/api/pins/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.title").value("Test Pin"));

        verify(pinService, times(1)).getPinById(1L);
    }

    @Test
    void deletePin_shouldReturnNoContent() throws Exception {
        doNothing().when(pinService).deletePin(1L);

        mockMvc.perform(delete("/api/pins/1"))
            .andExpect(status().isNoContent());

        verify(pinService, times(1)).deletePin(1L);
    }
}
