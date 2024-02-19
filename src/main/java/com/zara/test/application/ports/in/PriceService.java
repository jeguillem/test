package com.zara.test.application.ports.in;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.zara.test.application.ports.out.PriceRepository;
import com.zara.test.domain.PriceDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PriceService {

	private final PriceRepository priceRepository;
	
	public PriceDTO findPricesByProductIdAndBrandIdAndDate(LocalDateTime applicationDate, String productId, Long brandId) {
		return this.priceRepository.findPricesByProductIdAndBrandIdAndDate(applicationDate, productId, brandId);
	}
}
