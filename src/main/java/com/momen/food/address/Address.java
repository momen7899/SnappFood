package com.momen.food.address;

import com.momen.food.common.BaseEntity;
import com.momen.food.order.Order;
import com.momen.food.user.User;
import lombok.Data;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "address_tb")
@Audited
public class Address extends BaseEntity {

    private String title;
    private String address;
    private String details;
    private String phoneNumber;
    private Point<G2D> location;

    @OneToMany
    private List<Order> order;

    @ManyToOne
    private User user;
}
