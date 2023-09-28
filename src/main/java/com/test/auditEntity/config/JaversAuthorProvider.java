package com.test.auditEntity.config;

import org.javers.spring.auditable.AuthorProvider;
import org.springframework.context.annotation.Configuration;

import com.test.auditEntity.service.UserService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class JaversAuthorProvider implements AuthorProvider {

    private final UserService userService;

    @Override
    public String provide() {

        return userService.getCurrentUserId();

    }

}
