package com.example.buildcompany.model.dto.response;

import com.example.buildcompany.model.entity.apartments.Apartment;
import java.time.LocalDate;
import lombok.Data;

@Data
public class ApartmentResponseDto {
  private Long id;
  private String numberOfApartment;
  private String residence;
  private String floor;
  private String flat;
  private LocalDate localDate;
  private String status;
  private String price;
  private String client;
  private String updateStatus;

  public ApartmentResponseDto(Long id, String numberOfApartment, String residence, String floor, String flat,
      LocalDate localDate, String status, String price, String client, String updateStatus) {
    this.id = id;
    this.numberOfApartment = numberOfApartment;
    this.residence = residence;
    this.floor = floor;
    this.flat = flat;
    this.localDate = localDate;
    this.status = status;
    this.price = price;
    this.client = client;
    this.updateStatus = updateStatus;
  }

  public static ApartmentResponseDto of(Apartment apartment){
    return new ApartmentResponseDto(
        apartment.getId(),
        apartment.getNumberOfApartment(),
        apartment.getResidential().getName(),
        apartment.getFloor(),
        apartment.getFlat(),
        apartment.getCreatedDate(),
        apartment.getStatusApartment().getName(),
        apartment.getPrice(),
        apartment.getClient(),
        apartment.getUpdatedStatus()
    );
  }
}
