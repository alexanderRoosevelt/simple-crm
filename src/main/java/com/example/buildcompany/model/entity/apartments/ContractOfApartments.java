package com.example.buildcompany.model.entity.apartments;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contract_of_apartments")
public class ContractOfApartments {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "apartment_id")
  private Apartment apartment;

  @Column(name = "number_of_contract", length = 255)
  private String numberOfContract;
}