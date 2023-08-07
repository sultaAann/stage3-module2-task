package com.mjc.school.service.dto;

import java.time.LocalDateTime;

public record AuthorDTORequest(
        Long id,
        String name
) {
}