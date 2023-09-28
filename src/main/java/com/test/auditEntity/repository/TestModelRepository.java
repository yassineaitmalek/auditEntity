package com.test.auditEntity.repository;

import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.stereotype.Repository;

import com.test.auditEntity.model.TestModel;

@Repository
@JaversSpringDataAuditable
public interface TestModelRepository extends AbstractRepository<TestModel, String> {

}