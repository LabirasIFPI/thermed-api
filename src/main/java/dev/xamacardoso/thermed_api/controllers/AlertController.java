package dev.xamacardoso.thermed_api.controllers;

import dev.xamacardoso.thermed_api.model.dto.AlertRequestDto;
import dev.xamacardoso.thermed_api.model.dto.AlertResponseDto;
import dev.xamacardoso.thermed_api.services.AlertService;
import dev.xamacardoso.thermed_api.services.TelegramService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/alert")
public class AlertController {
    private AlertService alertService;
    private TelegramService telegramService;

    public AlertController(AlertService alertService, TelegramService telegramService) {
        this.alertService = alertService;
        this.telegramService = telegramService;
    }

    @PostMapping
    public ResponseEntity<AlertResponseDto> save(@RequestBody AlertRequestDto alertRequestDto) {
        AlertResponseDto responseDto = alertService.save(alertRequestDto);
        telegramService.sendTelegramMessage(alertRequestDto, responseDto.timestamp());
        return ResponseEntity.status(200).body(responseDto);
    }
}
