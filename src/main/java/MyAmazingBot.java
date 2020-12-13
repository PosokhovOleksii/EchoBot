import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyAmazingBot extends TelegramLongPollingBot {
    public String getBotUsername() {
        return "MyAmazingBot";
    }

    public String getBotToken() {
        return "1410032442:AAEb4DpLUjRyoMKbbee8VNNlbB-Aq-YABHM";
    }


    public void onUpdateReceived(Update update) {

        // We check if the update has a message and the message has text
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            if (message_text.equals("/start")) {
                SendMessage message = new SendMessage() // Create a message object object
                        .setChatId(chat_id)
                        .setText("Виберіть один із пунктів меню: ");

                ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
                List<KeyboardRow> keyboard = new ArrayList<>();
                KeyboardRow row = new KeyboardRow();
                row.add("House");
                row.add("Trance");
                row.add("Techno");
                keyboard.add(row);
                keyboardMarkup.setKeyboard(keyboard);
                message.setReplyMarkup(keyboardMarkup);
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            } else if (message_text.equals("House")) {
                SendMessage message = new SendMessage()
                        .setChatId(chat_id)
                        .setText("https://www.youtube.com/watch?v=-RkQDlUV4Fc&ab_channel=TropicalHouseRadio");
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else if (message_text.equals("Trance")) {
                SendMessage message = new SendMessage()
                        .setChatId(chat_id)
                        .setText("https://www.youtube.com/watch?v=iXAbte4QXKs&ab_channel=TheGrandSound");
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }

            }
            else if (message_text.equals("Techno")){
                SendMessage message = new SendMessage()
                        .setChatId(chat_id)
                        .setText("https://www.youtube.com/watch?v=5ZBgx1NeUWg&ab_channel=WejustmanRecords");
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

