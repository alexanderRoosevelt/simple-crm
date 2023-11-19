package com.example.buildcompany.controller;

import com.example.buildcompany.model.dto.basic.PageRequestDto;
import com.example.buildcompany.model.dto.request.ManagerRequestDto;
import com.example.buildcompany.model.dto.response.ManagerResponseDto;
import com.example.buildcompany.service.ManagerService;
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

@Tag(name = "Контроллер по работе с менеджерами", description = "операции по работе с менеджерами")
@RestController
@RequestMapping("/api/manager")
@RequiredArgsConstructor
public class ManagerController {

  private final ManagerService managerService;

  @Operation(summary = "Получить все данные")
  @PostMapping("/page")
  public Page<ManagerResponseDto> getPage(@RequestBody PageRequestDto pageRequest) {
    return managerService.getPageManagers(pageRequest);
  }

  @Operation(summary = "Получить инфу о менеджере по id")
  @GetMapping("/{managerId}")
  public ResponseEntity<ManagerResponseDto> getManagerById(@PathVariable Long managerId) {
    return ResponseEntity.ok(managerService.findManagerById(managerId));
  }

  @Operation(summary = "Создать менеджера")
  @PostMapping("/create")
  public ResponseEntity<ManagerResponseDto> createManager(
      @RequestBody ManagerRequestDto managerRequest) {
    return ResponseEntity.ok(managerService.createManager(managerRequest));
  }

  @Operation(summary = "Обновить менеджера")
  @PutMapping("/update/{managerId}")
  public ResponseEntity<ManagerResponseDto> updateManager(@PathVariable Long managerId,
      ManagerRequestDto managerRequest) {
    return ResponseEntity.ok(managerService.updateManager(managerId, managerRequest));
  }

  @Operation(summary = "Удалить менеджера")
  @DeleteMapping("/delete/{managerId}")
  public ResponseEntity<Boolean> updateManager(@PathVariable Long managerId) {
    return ResponseEntity.ok(managerService.deleteManagerById(managerId));
  }
}
