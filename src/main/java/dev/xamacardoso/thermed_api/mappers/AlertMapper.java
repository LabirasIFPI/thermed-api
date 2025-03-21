package dev.xamacardoso.thermed_api.mappers;

import dev.xamacardoso.thermed_api.model.Alert;
import dev.xamacardoso.thermed_api.model.Device;
import dev.xamacardoso.thermed_api.model.dto.AlertRequestDto;
import dev.xamacardoso.thermed_api.model.dto.AlertResponseDto;
import dev.xamacardoso.thermed_api.repositories.DeviceRepository;
import org.springframework.stereotype.Component;

// Classe auxiliar para preparar corpo de resposta de requisições de alerta e outras operações
@Component
public class AlertMapper {
    private DeviceRepository deviceRepository;

    public AlertMapper(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Alert toEntity(AlertRequestDto dto){
        Device device = this.deviceRepository.findByDeviceId(dto.deviceId()).orElseThrow(() -> new RuntimeException("Device not found!!!"));

        return new Alert(device);
    }

    public AlertResponseDto toResponse(Alert alert){
        return new AlertResponseDto(alert.getDevice().getDeviceId(), alert.getTimestamp());
    }
}
