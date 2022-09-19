package com.momen.food.user;


import com.momen.food.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserDTO extends BaseDTO {
    @ApiModelProperty(required = true, hidden = false)
    private String name;
    @ApiModelProperty(required = true, hidden = false)
    private String phoneNumber;
}
