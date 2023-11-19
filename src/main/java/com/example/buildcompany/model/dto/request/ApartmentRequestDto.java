package com.example.buildcompany.model.dto.request;

import lombok.Data;

@Data
public class ApartmentRequestDto {

  private String numberOfApartment;
  private Integer residenceId;
  private String floor;
  private String flat;
  private Integer statusId;
  private String price;
  private String client;
  private String updateStatus;
}
