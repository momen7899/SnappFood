package com.momen.food.supplier_category;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplierCategoryMapper {
    SupplierCategory toSupplierCategory(SupplierCategoryDTO supplierCategoryDTO);
    SupplierCategoryDTO toSupplierCategoryDTO(SupplierCategory supplierCategory);
    List<SupplierCategoryDTO> toSupplierCategoryDTOs(List<SupplierCategory> supplierCategories);
}
