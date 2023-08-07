package com.mjc.school.service.dto;

import java.time.LocalDateTime;

public record AuthorDTOResponse(
        Long id,
        String name,
        LocalDateTime createDate,
        LocalDateTime lastUpdatedDate
) {
}