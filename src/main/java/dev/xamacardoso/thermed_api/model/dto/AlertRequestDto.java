package dev.xamacardoso.thermed_api.model.dto;

import java.time.LocalDateTime;

public record AlertRequestDto(String deviceId, Integer temperature, Integer maxTemperature, Integer minTemperature) {
}
