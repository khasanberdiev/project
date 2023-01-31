package io.my.featureservice.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FeatureResponseModel {
    private String featureName;
    private String description;
}
