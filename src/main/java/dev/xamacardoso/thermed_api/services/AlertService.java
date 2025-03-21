package dev.xamacardoso.thermed_api.services;

import dev.xamacardoso.thermed_api.mappers.AlertMapper;
import dev.xamacardoso.thermed_api.model.Alert;
import dev.xamacardoso.thermed_api.model.dto.AlertRequestDto;
import dev.xamacardoso.thermed_api.model.dto.AlertResponseDto;
import dev.xamacardoso.thermed_api.repositories.AlertRepository;
import dev.xamacardoso.thermed_api.repositories.DeviceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Serviço para gerenciar o salvamento de alertas
@Service
public class AlertService {
    private AlertRepository alertRepository;
    private DeviceRepository deviceRepository;
    private AlertMapper alertMapper;

    public AlertService(AlertRepository alertRepository, DeviceRepository deviceRepository, AlertMapper alertMapper) {
        this.alertRepository = alertRepository;
        this.deviceRepository = deviceRepository;
        this.alertMapper = alertMapper;
    }

    @Transactional
    public AlertResponseDto save(AlertRequestDto dto) {
        this.deviceRepository.findByDeviceId(dto.deviceId()).orElseThrow(() -> new RuntimeException("No such device registered!"));
        Alert savedAlert = this.alertRepository.save(this.alertMapper.toEntity(dto));
        return alertMapper.toResponse(savedAlert);
    }
}
