package io.my.featureservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.my.featureservice.model.Feature;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
    
}
