package io.my.featureservice.service;


import io.my.featureservice.model.Feature;
import io.my.featureservice.repository.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    private FeatureRepository featureRepository;

    @Override
    public Feature create(Feature feature) {
        return featureRepository.save(feature);
    }

    @Override
    public void delete(Long id) {
        Optional<Feature> feature=featureRepository.findById(id);
        if(feature.isEmpty()){
            throw new NullPointerException("Does not exist");
        }
        featureRepository.deleteById(id);

    }

    @Override
    public List<Feature> getAll() {
        return (List<Feature>)featureRepository.findAll();
    }

    @Override
    public Optional<Feature> findById(Long id) {
        Optional<Feature> feature=featureRepository.findById(id);
        if(feature.isEmpty()){
            throw new NullPointerException("Does not exist");
        }
        return feature;
    }
}
