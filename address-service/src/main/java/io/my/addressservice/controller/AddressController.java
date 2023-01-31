package io.my.addressservice.controller;

import io.my.addressservice.model.Address;
import io.my.addressservice.model.request.AddressRequestModel;
import io.my.addressservice.model.response.AddressResponseModel;
import io.my.addressservice.service.AddressService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressResponseModel> create(@RequestBody AddressRequestModel addressRequestModel){
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Address feature=modelMapper.map(addressRequestModel, Address.class);
        Address savedFeature=addressService.create(feature);
        AddressResponseModel categoryResponseModel=modelMapper.map(savedFeature, AddressResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponseModel);
    }

    @GetMapping
    public ResponseEntity<List<AddressResponseModel>> getAll(){
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<Address> addresses=addressService.getAll();
        System.out.println(addresses);


        List<AddressResponseModel> body=addresses.stream().map(category->modelMapper.map(category, AddressResponseModel.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") long id){
        addressService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
