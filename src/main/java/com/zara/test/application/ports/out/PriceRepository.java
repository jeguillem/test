package com.zara.test.application.ports.out;

import java.time.LocalDateTime;

import com.zara.test.domain.PriceDTO;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public interface PriceRepository {

	PriceDTO findPricesByProductIdAndBrandIdAndDate(LocalDateTime applicationDate, String productId, Long brandId);
}
