package com.example.buildcompany.model.entity.apartments;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "apartments")
public class Apartment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "number_of_apartment", length = 32)
  private String numberOfApartment;

  @ManyToOne
  @JoinColumn(name = "residential")
  private Residential residential;

  @Column(length = 16)
  private String floor;

  @Column(length = 16)
  private String flat;

  @Column(name = "created_date")
  private LocalDate createdDate;

  @ManyToOne
  @JoinColumn(name = "status_apartment")
  private StateApartment statusApartment;

  @Column(length = 64)
  private String price;

  @Column(length = 255)
  private String client;

  @Column(name = "updated_status", length = 255)
  private String updatedStatus;
}
