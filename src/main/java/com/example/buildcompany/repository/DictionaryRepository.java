package com.example.buildcompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface DictionaryRepository <T, ID> extends JpaRepository<T, ID> {

}