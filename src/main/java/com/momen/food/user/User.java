package com.momen.food.user;

import com.momen.food.address.Address;
import com.momen.food.common.BaseEntity;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = User.TABLE_NAME)
@Audited
public class User extends BaseEntity {

    public static final String TABLE_NAME = "user_tb";

    private String name;
    private String phoneNumber;

    @OneToMany
    private List<Address> addresses;
}
