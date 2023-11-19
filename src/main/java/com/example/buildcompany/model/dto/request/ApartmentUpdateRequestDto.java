package com.example.buildcompany.model.dto.request;

import lombok.Data;

@Data
public class ApartmentUpdateRequestDto {
  private Long apartmentId;
  private String clientFullName;
  private String numberOfContract;
  private Integer statusId;
}
