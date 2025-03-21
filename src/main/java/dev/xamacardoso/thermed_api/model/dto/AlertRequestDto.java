package dev.xamacardoso.thermed_api.model.dto;

public record AlertRequestDto(String deviceId, Integer temperature, Integer maxTemperature, Integer minTemperature) {
}
