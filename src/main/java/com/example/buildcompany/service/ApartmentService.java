package com.example.buildcompany.service;

import com.example.buildcompany.model.dto.basic.PageRequestDto;
import com.example.buildcompany.model.dto.request.ApartmentRequestDto;
import com.example.buildcompany.model.dto.request.ApartmentUpdateRequestDto;
import com.example.buildcompany.model.dto.request.filter.FilterApartmentRequestDto;
import com.example.buildcompany.model.dto.response.ApartmentResponseDto;
import org.springframework.data.domain.Page;

public interface ApartmentService {

  ApartmentResponseDto createApartment(ApartmentRequestDto apartmentRequest);

  ApartmentResponseDto updateApartment(ApartmentUpdateRequestDto apartmentUpdateRequest);

  ApartmentResponseDto findApartmentById(Long apartmentId);

  Page<ApartmentResponseDto> getPageOfApartments(FilterApartmentRequestDto pageRequest);

  boolean deleteApartmentById(Long apartmentId);

}
