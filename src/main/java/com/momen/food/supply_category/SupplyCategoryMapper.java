package com.momen.food.supply_category;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplyCategoryMapper {

    SupplyCategory toSupplyCategory(SupplyCategoryDTO dto);

    SupplyCategoryDTO toSupplyCategoryDTO(SupplyCategory category);

    List<SupplyCategoryDTO> toSupplyCategoryDTOs(List<SupplyCategory> categories);
}
