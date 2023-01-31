package io.my.estateservice.controller;

import io.my.estateservice.model.Estate;
import io.my.estateservice.model.EstateRequestModel;
import io.my.estateservice.model.EstateResponseModel;
import io.my.estateservice.service.EstateService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/estate")
public class EstateController {

    @Autowired
    private EstateService estateService;

    @GetMapping("/get")
    public String get(){
        return "works";
    }

    @PostMapping
    public ResponseEntity<EstateResponseModel> create(@RequestBody EstateRequestModel estateRequestModel){
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Estate estate=modelMapper.map(estateRequestModel, Estate.class);
        Estate savedEstate=estateService.create(estate);
        EstateResponseModel body=modelMapper.map(savedEstate, EstateResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(body);

    }
    @GetMapping
    public ResponseEntity<List<EstateResponseModel>> getAll(){
        ModelMapper modelMapper=new ModelMapper();
        System.out.println("hi kkikosan");
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<EstateResponseModel> estateResponseModels=estateService.getAll()
                .stream().map(estate->modelMapper.map(estate, EstateResponseModel.class))
                .collect(Collectors.toList());
        System.out.println(estateResponseModels);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id) throws Exception {
        estateService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstateResponseModel> getById(@PathVariable("id") long id){
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        EstateResponseModel body=modelMapper.map(estateService.findById(id), EstateResponseModel.class);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
}
