package bluemoon.nikedrawalertbot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class TokenConfig {

    private static String token;
    private static String id;

    @Value("${telegramInfo.myToken}")
    public void setToken(String myToken) {
        this.token = myToken;
    }
    @Value("${telegramInfo.chatId}")
    public void setId(String chatId) {
        this.id = chatId;
    }

    public String getToken() {
        return token;
    }

    public String getId() {
        return id;
    }
}
