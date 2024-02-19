package com.zara.test;

import com.zara.test.application.ports.in.PriceService;
import com.zara.test.domain.PriceDTO;
import com.zara.test.infrastructure.controller.PriceController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceControllerTest {

    @Mock
    private PriceService priceService;

    @InjectMocks
    private PriceController priceController;

    private LocalDateTime dateTime14_10;
    private LocalDateTime dateTime14_16;
    private LocalDateTime dateTime14_21;
    private LocalDateTime dateTime15_10;
    private LocalDateTime dateTime16_21;

    @BeforeEach
    void setUp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        dateTime14_10 = LocalDateTime.parse("2024-02-14 10:00:00", formatter);
        dateTime14_16 = LocalDateTime.parse("2024-02-14 16:00:00", formatter);
        dateTime14_21 = LocalDateTime.parse("2024-02-14 21:00:00", formatter);
        dateTime15_10 = LocalDateTime.parse("2024-02-15 10:00:00", formatter);
        dateTime16_21 = LocalDateTime.parse("2024-02-16 21:00:00", formatter);
    }

    @Test
    void testGetPrice_14_10() {
        when(priceService.findPricesByProductIdAndBrandIdAndDate(dateTime14_10, "35455", 1L)).thenReturn(new PriceDTO());
        ResponseEntity<Map<String, Object>> responseEntity = priceController.getPrice("2024-02-14 10:00:00", "35455", 1L);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testGetPrice_14_16() {
        when(priceService.findPricesByProductIdAndBrandIdAndDate(dateTime14_16, "35455", 1L)).thenReturn(new PriceDTO());
        ResponseEntity<Map<String, Object>> responseEntity = priceController.getPrice("2024-02-14 16:00:00", "35455", 1L);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testGetPrice_14_21() {
        when(priceService.findPricesByProductIdAndBrandIdAndDate(dateTime14_21, "35455", 1L)).thenReturn(new PriceDTO());
        ResponseEntity<Map<String, Object>> responseEntity = priceController.getPrice("2024-02-14 21:00:00", "35455", 1L);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void testGetPrice_15_10() {
        when(priceService.findPricesByProductIdAndBrandIdAndDate(dateTime15_10, "35455", 1L)).thenReturn(null);
        ResponseEntity<Map<String, Object>> responseEntity = priceController.getPrice("2024-02-15 10:00:00", "35455", 1L);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testGetPrice_16_21() {
        when(priceService.findPricesByProductIdAndBrandIdAndDate(dateTime16_21, "35455", 1L)).thenReturn(null);
        ResponseEntity<Map<String, Object>> responseEntity = priceController.getPrice("2024-02-16 21:00:00", "35455", 1L);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }
}

