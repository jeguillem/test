package com.zara.test.infrastructure.adapter.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import com.zara.test.application.ports.out.PriceRepository;
import com.zara.test.domain.PriceDTO;
import com.zara.test.infrastructure.adapter.PriceCrudRepository;
import com.zara.test.infrastructure.mapper.PriceMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PriceRepositoryImpl  implements PriceRepository{

	private final PriceCrudRepository priceCrudRepository;
	private final PriceMapper priceMapper;

	@Override
	public PriceDTO findPricesByProductIdAndBrandIdAndDate(LocalDateTime applicationDate, String productId,
			Long brandId) {
		return this.priceCrudRepository.findPricesByProductIdAndBrandIdAndDate(applicationDate, productId, brandId)
				.map(this.priceMapper::toDto)
				.orElse(null);
	}
	
}
