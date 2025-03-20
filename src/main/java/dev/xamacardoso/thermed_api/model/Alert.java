package dev.xamacardoso.thermed_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_alerts")
public class Alert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    public Alert(){}

    public Alert(Device device){
        this.device = device;
        this.timestamp = LocalDateTime.now();
    }
}
