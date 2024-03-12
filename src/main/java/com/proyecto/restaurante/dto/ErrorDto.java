package com.proyecto.restaurante.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Builder
@RequiredArgsConstructor
public class ErrorDto {
    private final String code;
    private final String debugMessage;
    private final List<String> details;
    private final LocalDateTime time;
}
