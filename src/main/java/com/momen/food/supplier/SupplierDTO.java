package com.momen.food.supplier;

import com.momen.food.common.BaseDTO;
import com.momen.food.supplier_category.SupplierCategory;
import com.momen.food.supply.Supply;
import com.momen.food.supply_category.SupplyCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SupplierDTO extends BaseDTO {

    @ApiModelProperty(required = true)
    private String title;
    @ApiModelProperty(required = true)
    private String image;

    @ApiModelProperty(hidden = true)
    private List<Supply> supplies;

    @ApiModelProperty(hidden = true)
    private SupplierCategory category;

    @ApiModelProperty(hidden = true)
    private List<SupplyCategory> supplyCategories;
}
