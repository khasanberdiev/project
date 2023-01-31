package io.my.featureservice.service;

import java.util.List;
import java.util.Optional;

import io.my.featureservice.model.Feature;
import io.my.featureservice.model.FeatureRequestModel;

public interface FeatureService {
    Feature create(Feature feature);
    void delete(Long id);
    List<Feature> getAll();
    Optional<Feature> findById(Long id);
}
