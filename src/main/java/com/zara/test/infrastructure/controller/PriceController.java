package com.zara.test.infrastructure.controller;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zara.test.application.ports.in.PriceService;
import com.zara.test.domain.PriceDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ap1/v1/price")
@Validated
public class PriceController {

	private final PriceService priceService;
	
	@GetMapping("")
	public ResponseEntity<Map<String, Object>> getPrice(
			@RequestParam @NotBlank String applicationDate, 
			@RequestParam @NotBlank String productId, 
			@RequestParam @NotNull Long brandId){
		
		Map<String, Object> response = new HashMap<>();
		PriceDTO price = null;
		
		try {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        LocalDateTime fechaLocalDateTime = LocalDateTime.parse(applicationDate, formatter);
			price = this.priceService.findPricesByProductIdAndBrandIdAndDate(fechaLocalDateTime,productId, brandId);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(price == null) {
			response.put("mensaje", "El price no existe en la base de datos!");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		response.put("data", price);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
		
}
