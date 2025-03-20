package dev.xamacardoso.thermed_api.mappers;

import dev.xamacardoso.thermed_api.model.Alert;
import dev.xamacardoso.thermed_api.model.Device;
import dev.xamacardoso.thermed_api.model.dto.AlertRequestDto;
import dev.xamacardoso.thermed_api.model.dto.AlertResponseDto;
import dev.xamacardoso.thermed_api.repositories.DeviceRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@RequiredArgsConstructor
public class AlertMapper {
    private final DeviceRepository deviceRepository;

    public Alert toEntity(AlertRequestDto dto){
        Device device = this.deviceRepository.findByDeviceId(dto.deviceId()).orElseThrow(() -> new RuntimeException("Device not found!!!"));

        return new Alert(device);
    }

    public AlertResponseDto toResponse(Alert alert){
        return new AlertResponseDto(alert.getDevice().getDeviceId(), alert.getTimestamp());
    }
}
