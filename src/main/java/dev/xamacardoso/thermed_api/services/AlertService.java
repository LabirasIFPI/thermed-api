package dev.xamacardoso.thermed_api.services;

import dev.xamacardoso.thermed_api.mappers.AlertMapper;
import dev.xamacardoso.thermed_api.model.Alert;
import dev.xamacardoso.thermed_api.model.dto.AlertRequestDto;
import dev.xamacardoso.thermed_api.model.dto.AlertResponseDto;
import dev.xamacardoso.thermed_api.repositories.AlertRepository;
import dev.xamacardoso.thermed_api.repositories.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AlertService {

    @Autowired
    private final AlertRepository alertRepository;
    @Autowired
    private final DeviceRepository deviceRepository;
    @Autowired
    private final AlertMapper alertMapper;

    @Transactional
    public AlertResponseDto save(AlertRequestDto dto) {
        this.deviceRepository.findByDeviceId(dto.deviceId()).orElseThrow(() -> new RuntimeException("No such device registered!"));
        Alert savedAlert = this.alertRepository.save(this.alertMapper.toEntity(dto));
        return alertMapper.toResponse(savedAlert);
    }
}
