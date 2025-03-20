package dev.xamacardoso.thermed_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String deviceId;

    private String location;
    private String description;

    @Column(nullable = false)
    private String telegramUserId;

    public Device() {}

    public Device(String location, String description, String telegramUserId) {
        this.location = location;
        this.description = description;
        this.telegramUserId = telegramUserId;
    }
}
