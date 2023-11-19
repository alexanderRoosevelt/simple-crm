package com.example.buildcompany.model.dto.request;

import lombok.Data;

@Data
public class ManagerRequestDto {
  private String firstName;
  private String lastName;
  private String patronymic;
  private String phone;
  private String mail;
  private String password;
  private Integer roleId;
}
