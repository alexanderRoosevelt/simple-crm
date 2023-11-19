package com.example.buildcompany.controller;

import com.example.buildcompany.model.dto.basic.PageRequestDto;
import com.example.buildcompany.model.dto.request.ApartmentRequestDto;
import com.example.buildcompany.model.dto.request.ApartmentUpdateRequestDto;
import com.example.buildcompany.model.dto.request.filter.FilterApartmentRequestDto;
import com.example.buildcompany.model.dto.response.ApartmentResponseDto;
import com.example.buildcompany.service.ApartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Контроллер по работе с квартирами", description = "операции по работе с квартирами")
@RestController
@RequestMapping("/api/apartments")
@RequiredArgsConstructor
public class ApartmentsController {

  private final ApartmentService apartmentService;

  @Operation(summary = "Получить все данные")
  @PostMapping("/page")
  public Page<ApartmentResponseDto> getPageApartments(@RequestBody FilterApartmentRequestDto pageRequest) {
    return apartmentService.getPageOfApartments(pageRequest);
  }

  @Operation(summary = "Создание записи по квартире")
  @PostMapping("/create")
  public ResponseEntity<ApartmentResponseDto> createApartments(
      @RequestBody ApartmentRequestDto apartmentRequest) {
    return ResponseEntity.ok(apartmentService.createApartment(apartmentRequest));
  }

  @Operation(summary = "Обновить запись о квартире")
  @PutMapping("/update")
  public ResponseEntity<ApartmentResponseDto> createApartments(
      @RequestBody ApartmentUpdateRequestDto apartmentRequest) {
    return ResponseEntity.ok(apartmentService.updateApartment(apartmentRequest));
  }

  @Operation(summary = "Получить инфу по квартире")
  @GetMapping("/{apartmentId}")
  public ResponseEntity<ApartmentResponseDto> getApartment(@PathVariable Long apartmentId) {
    return ResponseEntity.ok(apartmentService.findApartmentById(apartmentId));
  }

  @Operation(summary = "Удалить квартиру")
  @DeleteMapping("/delete/{apartmentId}")
  public ResponseEntity<Boolean> deleteApartment(@PathVariable Long apartmentId) {
    return ResponseEntity.ok(apartmentService.deleteApartmentById(apartmentId));
  }
}
