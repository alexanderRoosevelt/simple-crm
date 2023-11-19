package com.example.buildcompany.repository;

import com.example.buildcompany.model.entity.apartments.ContractOfApartments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractOfApartmentsRepository extends JpaRepository<ContractOfApartments, Long> {

}
