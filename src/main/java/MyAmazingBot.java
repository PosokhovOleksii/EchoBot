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

            SendMessage message = new SendMessage() // Create a message object object
                    .setChatId(chat_id)
                    .setText(message_text);

            ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
            List <KeyboardRow> keyboard = new ArrayList<KeyboardRow>();
            KeyboardRow row = new KeyboardRow();

            row.add("Row 1 Button 1");
            row.add("Row 2 Button 2");
            row.add("Row 3 Button 3");

            keyboard.add(row);

            row = new KeyboardRow();

            row.add("Row 2 Button 1");
            row.add("Row 2 Button 2");
            row.add("Row 3 Butoon 3");

            keyboard.add(row);

            keyboardMarkup.setKeyboard(keyboard);
            message.setReplyMarkup(keyboardMarkup);
            try {
                execute(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}

