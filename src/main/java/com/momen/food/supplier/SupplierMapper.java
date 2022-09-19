package com.momen.food.supplier;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    Supplier toSupplier(SupplierDTO supplierDTO);

    SupplierDTO toSupplierDTO(Supplier supplier);

    List<SupplierDTO> toSupplierDTOs(List<Supplier> suppliers);

}
