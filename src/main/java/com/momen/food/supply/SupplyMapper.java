package com.momen.food.supply;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplyMapper {

    Supply toSupply(SupplyDTO supplyDTO);

    SupplyDTO toSupplyDto(Supply supply);

    List<SupplyDTO> toSupplierDTOs(List<Supply> supplies);

}
