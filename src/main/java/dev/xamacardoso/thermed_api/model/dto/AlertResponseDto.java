package dev.xamacardoso.thermed_api.model.dto;

import java.time.LocalDateTime;

public record AlertResponseDto(String deviceId, LocalDateTime timestamp) {
}
