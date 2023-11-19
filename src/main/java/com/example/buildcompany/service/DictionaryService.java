package com.example.buildcompany.service;

import com.example.buildcompany.model.entity.apartments.Residential;
import com.example.buildcompany.model.entity.apartments.StateApartment;
import com.example.buildcompany.model.entity.users.Role;
import java.util.List;

public interface DictionaryService {

  List<Role> findRoles();
  List<Residential> findResidentials();

  List<StateApartment> findStateApartments();
}
