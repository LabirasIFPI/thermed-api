package dev.xamacardoso.thermed_api.repositories;

import dev.xamacardoso.thermed_api.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    Optional<Device> findByDeviceId(String deviceId);
}
