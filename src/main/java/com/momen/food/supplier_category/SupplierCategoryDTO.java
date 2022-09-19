package com.momen.food.supplier_category;

import com.momen.food.common.BaseDTO;
import com.momen.food.supplier.Supplier;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SupplierCategoryDTO extends BaseDTO {
    @ApiModelProperty(required = true)
    private String name;
    @ApiModelProperty(required = true)
    private String icon;
    @ApiModelProperty(hidden = true)
    private List<Supplier> suppliers;

}