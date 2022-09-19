package com.momen.food.address;

import com.momen.food.common.BaseDTO;
import com.momen.food.order.Order;
import com.momen.food.user.User;
import lombok.Data;

import java.util.List;

@Data
public class AddressDTO extends BaseDTO {
    private String title;
    private String address;
    private String details;
    private String phoneNumber;
    private LocationDTO location;
    private List<Order> order;
    private User user;
}
