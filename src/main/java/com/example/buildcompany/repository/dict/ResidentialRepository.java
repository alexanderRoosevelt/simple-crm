package com.example.buildcompany.repository.dict;

import com.example.buildcompany.model.entity.apartments.Residential;
import com.example.buildcompany.repository.DictionaryRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentialRepository extends DictionaryRepository<Residential, Integer> {

}
