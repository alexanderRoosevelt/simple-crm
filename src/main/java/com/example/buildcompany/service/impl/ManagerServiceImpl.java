package com.example.buildcompany.service.impl;

import com.example.buildcompany.model.dto.basic.PageRequestDto;
import com.example.buildcompany.model.dto.request.ManagerRequestDto;
import com.example.buildcompany.model.dto.response.ManagerResponseDto;
import com.example.buildcompany.model.entity.users.Manager;
import com.example.buildcompany.model.entity.users.User;
import com.example.buildcompany.repository.ManagerRepository;
import com.example.buildcompany.repository.UserRepository;
import com.example.buildcompany.repository.dict.RoleRepository;
import com.example.buildcompany.service.ManagerService;
import java.time.LocalDate;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

  private final UserRepository userRepository;
  private final ManagerRepository managerRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public ManagerResponseDto createManager(ManagerRequestDto managerRequest) {
    try {
      User user = new User();
      user.setCreatedDate(LocalDate.now());
      user.setMail(managerRequest.getMail());
      user.setPassword(passwordEncoder.encode(managerRequest.getPassword()));
      user.setPhone(managerRequest.getPhone());
      user.setFirstName(managerRequest.getFirstName());
      user.setLastName(managerRequest.getLastName());
      user.setPatronymic(managerRequest.getPatronymic());
      user.setRole(roleRepository.findById(managerRequest.getRoleId()).orElseThrow());
      User saveUser = userRepository.save(user);
      Manager manager = new Manager();
      manager.setUser(saveUser);
      return ManagerResponseDto.of(managerRepository.save(manager));
    } catch (Exception ex) {
      log.error(ex.toString());
      return null;
    }
  }

  @Override
  public ManagerResponseDto updateManager(Long managerId, ManagerRequestDto managerRequest) {

    Optional<Manager> optionalManager = managerRepository.findById(managerId);
    if (optionalManager.isEmpty()) {
      throw new RuntimeException(
          String.format("Такого пользователя c id = %s не существует", managerId));
    }
    Manager manager = optionalManager.get();
    manager.getUser().setFirstName(managerRequest.getFirstName());
    manager.getUser().setLastName(managerRequest.getLastName());
    manager.getUser().setPatronymic(managerRequest.getPatronymic());
    manager.getUser().setPhone(managerRequest.getPhone());
    manager.getUser().setMail(managerRequest.getMail());

    return ManagerResponseDto.of(managerRepository.save(manager));
  }

  @Override
  public Page<ManagerResponseDto> getPageManagers(PageRequestDto pageRequest) {
    Sort.Direction direction = Sort.Direction.fromString(pageRequest.getSortOrder());

    Sort sort = Sort.by(direction, pageRequest.getSortBy());

    Pageable pageable = PageRequest.of(pageRequest.getPage(), pageRequest.getSize(), sort);
    Page<Manager> managerPage = managerRepository.findAll(pageable);
    return managerPage.map(ManagerResponseDto::of);
  }

  @Override
  public ManagerResponseDto findManagerById(Long managerId) {
    Optional<Manager> optionalManager = managerRepository.findById(managerId);
    if (optionalManager.isEmpty()) {
      throw new RuntimeException(
          String.format("Такого пользователя c id = %s не существует", managerId));
    }

    return ManagerResponseDto.of(optionalManager.get());
  }

  @Override
  public boolean deleteManagerById(Long managerId) {
    try {
      Manager manager = managerRepository.findById(managerId).orElseThrow();
      managerRepository.delete(manager);
      return true;
    } catch (Exception ex) {
      log.error(ex.toString());
      return false;
    }
  }
}
