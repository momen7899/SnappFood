package com.momen.food.supply;

import com.momen.food.common.BaseDTO;
import com.momen.food.order_item.OrderItem;
import com.momen.food.supplier.Supplier;
import com.momen.food.supply_category.SupplyCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SupplyDTO extends BaseDTO {

    @ApiModelProperty(required = true)
    private String title;
    @ApiModelProperty(required = true)
    private String image;
    @ApiModelProperty(required = true)
    private String details;

    @ApiModelProperty(hidden = true)
    private SupplyCategory category;

    @ApiModelProperty(hidden = true)
    private Supplier supplier;

    @ApiModelProperty(hidden = true)
    private List<OrderItem> orderItem;

}
