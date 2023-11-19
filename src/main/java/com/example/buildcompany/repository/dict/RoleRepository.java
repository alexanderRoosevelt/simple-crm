package com.example.buildcompany.repository.dict;

import com.example.buildcompany.model.entity.users.Role;
import com.example.buildcompany.repository.DictionaryRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends DictionaryRepository<Role, Integer> {

}
