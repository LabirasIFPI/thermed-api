package dev.xamacardoso.thermed_api.repositories;

import dev.xamacardoso.thermed_api.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<Alert, Long> {
}
