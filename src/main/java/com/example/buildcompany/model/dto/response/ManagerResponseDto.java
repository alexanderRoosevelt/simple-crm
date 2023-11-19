package com.example.buildcompany.model.dto.response;

import com.example.buildcompany.model.entity.users.Manager;
import java.time.LocalDate;
import lombok.Data;

@Data
public class ManagerResponseDto {
  private String fullName;
  private String phone;
  private String mail;
  private LocalDate createdDate;
  private String countOfDeals;

  public ManagerResponseDto(String fullName, String phone, String mail, LocalDate createdDate,
      String countOfDeals) {
    this.fullName = fullName;
    this.phone = phone;
    this.mail = mail;
    this.createdDate = createdDate;
    this.countOfDeals = countOfDeals;
  }

  public static ManagerResponseDto of(Manager manager) {
    String fullName = String.format("%s %s %s",
        manager.getUser().getFirstName(),
        manager.getUser().getLastName(),
        manager.getUser().getPatronymic());
      return new ManagerResponseDto(
          fullName,
          manager.getUser().getPhone(),
          manager.getUser().getMail(),
          manager.getUser().getCreatedDate(),
          manager.getCountOfDeals() != null ? manager.getCountOfDeals().toString() : ""
      );
  }
}
