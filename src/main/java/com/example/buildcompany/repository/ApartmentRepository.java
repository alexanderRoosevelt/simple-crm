package com.example.buildcompany.repository;

import com.example.buildcompany.model.entity.apartments.Apartment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepository extends PagingAndSortingRepository<Apartment, Long> {

  Page<Apartment> findAll(Specification<Apartment> spec, Pageable pageable);

}
