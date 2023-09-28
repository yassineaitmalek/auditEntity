package com.test.auditEntity.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.auditEntity.dto.TestModelDTO;
import com.test.auditEntity.dto.audit.AuditDB;
import com.test.auditEntity.model.TestModel;
import com.test.auditEntity.service.AuditService;
import com.test.auditEntity.service.TestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/test")
@RequiredArgsConstructor
class TestController {

    private final TestService testService;

    private final AuditService auditService;

    @GetMapping("/audit")
    public List<AuditDB<TestModel>> audit() {
        return auditService.getSnapshots(TestModel.class);

    }

    @GetMapping
    public List<TestModel> get() {
        return testService.get();

    }

    @PostMapping
    public Optional<TestModel> create(@RequestBody TestModelDTO testModelDTO) {
        return testService.create(testModelDTO);

    }

    @PatchMapping("/{id}")
    public Optional<TestModel> update(@PathVariable String id, @RequestBody TestModelDTO testModelDTO) {
        return testService.update(id, testModelDTO);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        testService.delete(id);

    }

}
