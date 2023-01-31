package io.my.featureservice.controller;

import io.my.featureservice.model.Feature;
import io.my.featureservice.model.FeatureRequestModel;
import io.my.featureservice.model.FeatureResponseModel;
import io.my.featureservice.service.FeatureService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/feature")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @PostMapping
    public ResponseEntity<FeatureResponseModel> create(@RequestBody FeatureRequestModel featureRequestModel){
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Feature feature=modelMapper.map(featureRequestModel, Feature.class);
        Feature savedFeature=featureService.create(feature);
        FeatureResponseModel categoryResponseModel=modelMapper.map(savedFeature, FeatureResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponseModel);
    }

    @GetMapping
    public ResponseEntity<List<FeatureResponseModel>> getAll(){
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<Feature> categories=featureService.getAll();
        System.out.println(categories);


        List<FeatureResponseModel> body=categories.stream().map(category->modelMapper.map(category, FeatureResponseModel.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") long id){
        featureService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    
}
