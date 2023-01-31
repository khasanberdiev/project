package io.my.estateservice.service;

import io.my.estateservice.model.Estate;
import io.my.estateservice.model.SearchRequestModel;

import java.util.List;
import java.util.Optional;

public interface EstateService {
    Estate create(Estate estate);
    void delete(Long id) throws Exception;
    List<Estate> getAll();
    Optional<Estate> findById(Long id);
    Estate searchBy(SearchRequestModel searchRequestModel);

}
