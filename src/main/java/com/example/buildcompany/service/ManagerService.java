package com.example.buildcompany.service;

import com.example.buildcompany.model.dto.basic.PageRequestDto;
import com.example.buildcompany.model.dto.request.ManagerRequestDto;
import com.example.buildcompany.model.dto.response.ManagerResponseDto;
import org.springframework.data.domain.Page;

public interface ManagerService {

  ManagerResponseDto createManager(ManagerRequestDto managerRequest);

  ManagerResponseDto updateManager(Long managerId, ManagerRequestDto managerRequest);

  Page<ManagerResponseDto> getPageManagers(PageRequestDto pageRequest);

  ManagerResponseDto findManagerById(Long managerId);

  boolean deleteManagerById(Long managerId);
}
