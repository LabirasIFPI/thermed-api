package dev.xamacardoso.thermed_api.services;

import dev.xamacardoso.thermed_api.model.Device;
import dev.xamacardoso.thermed_api.model.dto.AlertRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class TelegramService {
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final String TELEGRAM_BOT_TOKEN = "7759623885:AAH9TQyGc7N24eY7rEo-YgcFh8UOUkpkE9U";
    private static final String TELEGRAM_MAINTANCE_GROUP_CHAT_ID = "-4734211587";
    private static final String TELEGRAM_API_URL = "https://api.telegram.org/bot" + TELEGRAM_BOT_TOKEN + "/sendMessage";

    private DeviceService deviceService;

    public TelegramService(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    // Envia uma mensagem via bot Telegram
    public void sendTelegramMessage(AlertRequestDto requestDto, LocalDateTime timestamp) {
        // Preparo da mensagem a ser enviada
        String message = String.format(
                "⚠️ *TEMPERATURA FORA DOS LIMITES!*\n" +
                        "🕛 *Data e Hora*: %s\n" +
                        "🌡️ Temperatura: %d\n"+
                        "🔥 Limite Maximo: %d\n"+
                        "❄️ Limite Minimo: %d\n"+
                        "⚙️ *Dispositivo*: %s\n",
                timestamp.format(fmt),
                requestDto.temperature(),
                requestDto.maxTemperature(),
                requestDto.minTemperature(),
                requestDto.deviceId()
        );

        // Prepara um JSON para enviar o alerta ao grupo de manutenção
        Map<String, String> telegramRequestBody = new HashMap<>();
        telegramRequestBody.put("chat_id", TELEGRAM_MAINTANCE_GROUP_CHAT_ID);
        telegramRequestBody.put("text", message);
        telegramRequestBody.put("parse_mode", "Markdown");

        // Envio do alerta para a equipe de manutenção
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(TELEGRAM_API_URL, telegramRequestBody, String.class);

        // Prepara e envia um alerta para o usuário associado ao dispositivo
        Device alertDevice = this.deviceService.findByDeviceId(requestDto.deviceId());
        telegramRequestBody.put("chat_id", alertDevice.getTelegramUserId());
        restTemplate.postForObject(TELEGRAM_API_URL, telegramRequestBody, String.class);
    }
}
