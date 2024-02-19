package com.zara.test.infrastructure.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;

import com.zara.test.domain.PriceDTO;
import com.zara.test.infrastructure.entity.PriceEntity;

@Mapper(componentModel = ComponentModel.SPRING)
public interface PriceMapper {

	PriceDTO toDto(PriceEntity entity);
	
	@InheritInverseConfiguration
	PriceEntity toEntity(PriceDTO dto);
	
	List<PriceDTO> toListDto( List<PriceEntity> listEntities);
}
