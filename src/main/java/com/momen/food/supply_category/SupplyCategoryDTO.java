package com.momen.food.supply_category;

import com.momen.food.common.BaseDTO;
import com.momen.food.supplier.Supplier;
import com.momen.food.supply.Supply;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SupplyCategoryDTO extends BaseDTO {
    @ApiModelProperty(required = true)
    private String name;
    @ApiModelProperty(required = true)
    private String icon;

    @ApiModelProperty(required = true)
    private Supplier supplier;

    @ApiModelProperty(hidden = true)
    private List<Supply> supplies;
}
