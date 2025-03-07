package com.mjc.school.service.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Scope("prototype")
public record AuthorDTOResponse(
        Long id,
        String name,
        LocalDateTime createdDate,
        LocalDateTime lastUpdatedDate
) {
}