package com.test.auditEntity.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.javers.core.Javers;
import org.javers.core.metamodel.object.CdoSnapshot;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.auditEntity.dto.audit.AuditDB;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class AuditService {

  private final Javers javers;

  private final ObjectMapper objectMapper;

  public <T> Optional<AuditDB<T>> mapSnapshotToEntity(CdoSnapshot snapshot, Class<T> clazz) {
    try {

      return Optional.of(objectMapper.readValue(javers.getJsonConverter().toJson(snapshot), auditTypeRef(clazz)));
    } catch (Exception e) {
      log.error(e.getMessage());
      return Optional.empty();
    }
  }

  public <T> TypeReference<AuditDB<T>> auditTypeRef(Class<T> clazz) {
    return new TypeReference<AuditDB<T>>() {
    };
  }

  public <T> List<AuditDB<T>> getSnapshots(Class<T> clazz) {

    return javers.findSnapshots(QueryBuilder.byClass(clazz).build())
        .stream()
        .map(e -> mapSnapshotToEntity(e, clazz))
        .filter(e -> e.isPresent())
        .map(e -> e.get())
        .collect(Collectors.toList());

  }

}