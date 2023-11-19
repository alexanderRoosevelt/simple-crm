package com.example.buildcompany.repository;

import com.example.buildcompany.model.entity.users.Manager;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends PagingAndSortingRepository<Manager,Long> {

}
