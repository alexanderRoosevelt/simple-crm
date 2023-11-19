package com.example.buildcompany.service.impl;

import com.example.buildcompany.model.entity.apartments.Residential;
import com.example.buildcompany.model.entity.apartments.StateApartment;
import com.example.buildcompany.model.entity.users.Role;
import com.example.buildcompany.repository.DictionaryRepository;
import com.example.buildcompany.service.DictionaryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DictionaryServiceImpl implements DictionaryService {

  private final DictionaryRepository<Role, Integer> roleRepository;
  private final DictionaryRepository<Residential, Integer> residentialRepository;
  private final DictionaryRepository<StateApartment, Integer> stateApartmentRepository;

  @Override
  public List<Role> findRoles() {
    return roleRepository.findAll();
  }

  @Override
  public List<Residential> findResidentials() {
    return residentialRepository.findAll();
  }

  @Override
  public List<StateApartment> findStateApartments() {
    return stateApartmentRepository.findAll();
  }
}
