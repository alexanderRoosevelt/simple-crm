package com.example.buildcompany.service.impl;

import com.example.buildcompany.model.dto.basic.PageRequestDto;
import com.example.buildcompany.model.dto.request.ApartmentRequestDto;
import com.example.buildcompany.model.dto.request.ApartmentUpdateRequestDto;
import com.example.buildcompany.model.dto.request.filter.FilterApartmentRequestDto;
import com.example.buildcompany.model.dto.response.ApartmentResponseDto;
import com.example.buildcompany.model.entity.apartments.Apartment;
import com.example.buildcompany.model.entity.apartments.ContractOfApartments;
import com.example.buildcompany.model.entity.apartments.Residential;
import com.example.buildcompany.model.entity.apartments.StateApartment;
import com.example.buildcompany.repository.ApartmentRepository;
import com.example.buildcompany.repository.ContractOfApartmentsRepository;
import com.example.buildcompany.repository.dict.ResidentialRepository;
import com.example.buildcompany.repository.dict.StateApartmentRepository;
import com.example.buildcompany.service.ApartmentService;
import java.time.LocalDate;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApartmentServiceImpl implements ApartmentService {

  private final ApartmentRepository apartmentRepository;
  private final StateApartmentRepository stateApartmentRepository;
  private final ResidentialRepository residentialRepository;
  private final ContractOfApartmentsRepository contractOfApartmentsRepository;

  @Override
  public ApartmentResponseDto createApartment(ApartmentRequestDto apartmentRequest) {
    try {
      Optional<StateApartment> stateApartment = stateApartmentRepository.findById(
          apartmentRequest.getStatusId());
      Optional<Residential> residential = residentialRepository.findById(
          apartmentRequest.getResidenceId());

      if (stateApartment.isEmpty() || residential.isEmpty()) {
        throw new RuntimeException();
      }

      Apartment apartment = new Apartment();
      apartment.setNumberOfApartment(apartmentRequest.getNumberOfApartment());
      apartment.setStatusApartment(stateApartment.get());
      apartment.setFlat(apartmentRequest.getFlat());
      apartment.setFloor(apartmentRequest.getFloor());
      apartment.setCreatedDate(LocalDate.now());
      apartment.setPrice(apartmentRequest.getPrice());
      apartment.setResidential(residential.get());
      apartment.setUpdatedStatus(apartmentRequest.getUpdateStatus());
      apartment.setClient(apartmentRequest.getClient());

      return ApartmentResponseDto.of(apartmentRepository.save(apartment));
    } catch (RuntimeException ex) {
      log.error(ex.toString());
      return null;
    }
  }

  @Override
  public ApartmentResponseDto updateApartment(ApartmentUpdateRequestDto apartmentUpdateRequest) {
    try {
      Optional<Apartment> findApartment = apartmentRepository.findById(
          apartmentUpdateRequest.getApartmentId());
      Optional<StateApartment> stateApartment = stateApartmentRepository.findById(
          apartmentUpdateRequest.getStatusId());

      if (findApartment.isEmpty() || stateApartment.isEmpty()) {
        throw new RuntimeException();
      }
      ContractOfApartments contractOfApartments = new ContractOfApartments();

      Apartment saveApartment = findApartment.get();
      saveApartment.setClient(apartmentUpdateRequest.getClientFullName());
      saveApartment.setStatusApartment(stateApartment.get());
      Apartment apartment = apartmentRepository.save(saveApartment);
      contractOfApartments.setApartment(apartment);
      contractOfApartments.setNumberOfContract(apartmentUpdateRequest.getNumberOfContract());
      contractOfApartmentsRepository.save(contractOfApartments);
      return ApartmentResponseDto.of(apartment);

    } catch (RuntimeException ex) {
      log.error(ex.toString());
      return null;
    }
  }

  @Override
  public ApartmentResponseDto findApartmentById(Long apartmentId) {
    Apartment apartment = apartmentRepository.findById(apartmentId).orElseThrow();
    return ApartmentResponseDto.of(apartment);
  }

  @Override
  public Page<ApartmentResponseDto> getPageOfApartments(FilterApartmentRequestDto pageRequest) {
    Sort.Direction direction = Sort.Direction.fromString(pageRequest.getSortOrder());

    Sort sort = Sort.by(direction, pageRequest.getSortBy());

    Pageable pageable = PageRequest.of(pageRequest.getPage(), pageRequest.getSize(), sort);
    Specification<Apartment> spec = Specification.where(null);

    if (!StringUtils.isEmpty(pageRequest.getStatusFilter())) {
      spec = spec.and((root, query, cb) ->
          cb.like(cb.lower(root.get("statusApartment").get("name")),
              "%" + pageRequest.getStatusFilter().toLowerCase() + "%")
      );
    }

    if (!StringUtils.isEmpty(pageRequest.getResidenceFilter())) {
      spec = spec.and((root, query, cb) ->
          cb.like(cb.lower(root.get("residential").get("name")),
              "%" + pageRequest.getResidenceFilter().toLowerCase() + "%")
      );
    }

    Page<Apartment> apartmentPage = apartmentRepository.findAll(spec, pageable);
    return apartmentPage.map(ApartmentResponseDto::of);
  }

  @Override
  public boolean deleteApartmentById(Long apartmentId) {
    try {
      Apartment apartment = apartmentRepository.findById(apartmentId).orElseThrow();
      apartmentRepository.delete(apartment);
      return true;
    } catch (Exception ex) {
      log.error(ex.toString());
      return false;
    }

  }
}
