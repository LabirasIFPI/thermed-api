package dev.xamacardoso.thermed_api.controllers;

import dev.xamacardoso.thermed_api.model.dto.AlertRequestDto;
import dev.xamacardoso.thermed_api.model.dto.AlertResponseDto;
import dev.xamacardoso.thermed_api.services.AlertService;
import dev.xamacardoso.thermed_api.services.TelegramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/alert")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @Autowired
    private TelegramService telegramService;

    @PostMapping
    public ResponseEntity<AlertResponseDto> save(@RequestBody AlertRequestDto alertRequestDto) {
        AlertResponseDto responseDto = alertService.save(alertRequestDto);
        telegramService.sendTelegramMessage(alertRequestDto, responseDto.timestamp());
        return ResponseEntity.ok(responseDto);
    }
}
