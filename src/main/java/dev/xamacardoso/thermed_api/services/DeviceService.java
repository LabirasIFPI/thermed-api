package dev.xamacardoso.thermed_api.services;

import dev.xamacardoso.thermed_api.model.Device;
import dev.xamacardoso.thermed_api.repositories.DeviceRepository;
import org.springframework.stereotype.Service;

// Servico para gerenciar os dispositivos registrados
@Service
public class DeviceService {
    private DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public Device findByDeviceId(String deviceId) {
        return deviceRepository.findByDeviceId(deviceId).orElseThrow(() -> new RuntimeException("Device not found"));
    }
}
