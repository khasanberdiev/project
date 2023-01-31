package io.my.estateservice.service;

import io.my.estateservice.model.Estate;
import io.my.estateservice.model.SearchRequestModel;
import io.my.estateservice.repository.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstateServiceImpl implements EstateService{

    @Autowired
    private EstateRepository estateRepository;

    @Override
    public Estate create(Estate estate) {
        return estateRepository.save(estate);
    }

    @Override
    public void delete(Long id){
        Optional<Estate> estate=estateRepository.findById(id);
        if(!estate.isPresent()){
            throw new NullPointerException("The estate does not exist");
        }
        estateRepository.deleteById(id);
    }

    @Override
    public List<Estate> getAll() {
        List<Estate> estates= (List<Estate>) estateRepository.findAll();
        return estates;
    }

    @Override
    public Optional<Estate> findById(Long id) {
        Optional<Estate> estate=estateRepository.findById(id);
        if(estate.isEmpty()){
            throw new NullPointerException("Property does nit exist");
        }
        return estate;

    }

    @Override
    public Estate searchBy(SearchRequestModel searchRequestModel) {

        return null;
    }


}
