package com.example.buildcompany.model.dto.request.filter;

import com.example.buildcompany.model.dto.basic.PageRequestDto;
import lombok.Data;

@Data
public class FilterApartmentRequestDto extends PageRequestDto {
  private String statusFilter;
  private String residenceFilter;
}
