package io.my.addressservice.service;

import io.my.addressservice.model.Address;
import io.my.addressservice.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address create(Address address) {

        return addressRepository.save(address);
    }

    @Override
    public void delete(Long id) {
        Optional<Address> address=addressRepository.findById(id);
        if(!address.isPresent()){
            throw new NullPointerException("Feature doen not exist");
        }
        addressRepository.deleteById(id);

    }

    @Override
    public List<Address> getAll() {
        return (List<Address>) addressRepository.findAll();
    }

    @Override
    public Optional<Address> findById(Long id) {
        Optional<Address> address=addressRepository.findById(id);
        if(!address.isPresent()){
            throw new NullPointerException("Feature doen not exist");
        }
        return address;
    }
}
