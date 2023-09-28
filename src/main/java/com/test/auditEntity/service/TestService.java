package com.test.auditEntity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.test.auditEntity.dto.TestModelDTO;
import com.test.auditEntity.model.TestModel;
import com.test.auditEntity.repository.TestModelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestService {

  private final TestModelRepository testModelRepository;

  public List<TestModel> get() {
    return testModelRepository.findAll();
  }

  public Optional<TestModel> create(TestModelDTO testModelDTO) {
    return Optional.of(testModelRepository.save(TestModel.builder().content(testModelDTO.getContent()).build()));
  }

  public Optional<TestModel> update(String id, TestModelDTO testModelDTO) {
    return testModelRepository.findById(id)
        .map(e -> {
          e.setContent(testModelDTO.getContent());
          return e;
        })
        .map(e -> Optional.of(testModelRepository.save(e)))
        .orElse(Optional.empty());
  }

  public void delete(String id) {
    testModelRepository.findById(id)
        .ifPresent(e -> testModelRepository.delete(e));
  }

}
