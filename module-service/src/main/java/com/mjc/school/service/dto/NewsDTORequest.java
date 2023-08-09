package com.mjc.school.service.dto;

import java.time.LocalDateTime;

public record NewsDTORequest (
        Long id,
        String title,
        String content,
        Long authorId
) {
}