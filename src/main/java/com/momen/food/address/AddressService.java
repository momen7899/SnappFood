package com.momen.food.address;

import java.util.List;

public interface AddressService {

    Address save(Address address);

    Address update(Address address);

    void delete(Long id);

    Address findById(Long id);

    List<Address> findAll();
}
