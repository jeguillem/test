package com.zara.test.infrastructure.adapter;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zara.test.infrastructure.entity.PriceEntity;

public interface PriceCrudRepository extends JpaRepository<PriceEntity, Long>{
	
	@Query("SELECT p "
			+ "FROM PriceEntity p "
			+ "WHERE p.productId = :productId "
			+ "    AND p.brandId = :brandId "
			+ "    AND :applicationDate BETWEEN p.startDate AND p.endDate "
			+ "    AND p.priority = ( "
			+ "        SELECT MAX(p1.priority) "
			+ "        FROM PriceEntity p1 "
			+ "        WHERE p1.productId = :productId "
			+ "            AND p1.brandId = :brandId "
			+ "            AND :applicationDate BETWEEN p1.startDate AND p1.endDate "
			+ "    )")
	Optional<PriceEntity> findPricesByProductIdAndBrandIdAndDate(@Param("applicationDate") LocalDateTime applicationDate, @Param("productId") String productId, @Param("brandId") Long brandId);

}
