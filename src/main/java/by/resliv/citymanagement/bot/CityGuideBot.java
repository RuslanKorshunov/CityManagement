package by.resliv.citymanagement.bot;

import by.resliv.citymanagement.entity.City;
import by.resliv.citymanagement.exception.ServiceException;
import by.resliv.citymanagement.service.ServiceInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class CityGuideBot extends TelegramLongPollingBot {
    private static final Logger logger;
    private static final String ERROR_MESSAGE;
    private static final String HELLO_MESSAGE;
    private static final String START;

    @Autowired
    private ServiceInterface<City> service;

    private String name;
    private String token;

    static {
        logger = LogManager.getLogger();
        ERROR_MESSAGE = "К сожалению, мне нечего сказать об этом городе.";
        HELLO_MESSAGE = "Привет! Введи название города, чтобы узнать о нем побольше.";
        START = "/start";
    }

    public CityGuideBot(String name, String token) {
        this.name = name;
        this.token = token;
    }

    public void onUpdateReceived(Update update) {
        String name = update.getMessage().getText();
        String message;
        if (name.equals(START)) {
            message = HELLO_MESSAGE;
        } else {
            try {
                City city = service.read(name);
                message = city.getInformation();
            } catch (ServiceException e) {
                logger.error(e);
                message = ERROR_MESSAGE;
            }
        }
        sendMsg(update.getMessage().getChatId().toString(), message);
    }

    public String getBotUsername() {
        return name;
    }

    public String getBotToken() {
        return token;
    }

    private void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            logger.error(e);
        }
    }
}
