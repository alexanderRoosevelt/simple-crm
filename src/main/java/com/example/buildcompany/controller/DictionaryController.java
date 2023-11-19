package com.example.buildcompany.controller;

import com.example.buildcompany.model.entity.apartments.Residential;
import com.example.buildcompany.model.entity.apartments.StateApartment;
import com.example.buildcompany.model.entity.users.Role;
import com.example.buildcompany.service.DictionaryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Справочник данных", description = "Все выпадающие списки")
@RestController
@RequestMapping("/api/dict")
@RequiredArgsConstructor
public class DictionaryController {

  private final DictionaryService dictionaryService;

  @Operation(summary = "Список ролей")
  @GetMapping("/roles")
  ResponseEntity<List<Role>> findRoles() {
    return ResponseEntity.ok(dictionaryService.findRoles());
  }

  @Operation(summary = "Список ЖК")
  @GetMapping("/residentials")
  ResponseEntity<List<Residential>> findResidentials() {
    return ResponseEntity.ok(dictionaryService.findResidentials());
  }

  @Operation(summary = "Список состояний жилья")
  @GetMapping("/state-of-apartments")
  ResponseEntity<List<StateApartment>> findStateOfApartments() {
    return ResponseEntity.ok(dictionaryService.findStateApartments());
  }
}

