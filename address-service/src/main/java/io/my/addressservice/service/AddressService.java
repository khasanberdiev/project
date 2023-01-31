package io.my.addressservice.service;

import io.my.addressservice.model.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Address create(Address address);
    void delete(Long id);
    List<Address> getAll();
    Optional<Address> findById(Long id);
}
