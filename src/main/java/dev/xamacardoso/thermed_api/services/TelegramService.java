package dev.xamacardoso.thermed_api.services;

import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class TelegramService {
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final String TELEGRAM_BOT_TOKEN = "7759623885:AAH9TQyGc7N24eY7rEo-YgcFh8UOUkpkE9U";
    private static final String TELEGRAM_MAINTANCE_GROUP_CHAT_ID = "-4734211587";
    private static final String TELEGRAM_API_URL = "https://api.telegram.org/bot" + TELEGRAM_BOT_TOKEN + "/sendMessage";
}
