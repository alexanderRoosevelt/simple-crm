package com.example.buildcompany.model.dto.basic;

import lombok.Data;

@Data
public class PageRequestDto {

  private int page;
  private int size;
  private String sortBy;
  private String sortOrder;
}
