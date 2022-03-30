package bluemoon.nikedrawalertbot;

import bluemoon.nikedrawalertbot.jsoup.nikeWeb.NikeWebJsoup;
import bluemoon.nikedrawalertbot.telegram.SendMessage;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NikeDrawAlertBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(NikeDrawAlertBotApplication.class, args);
//        NikeWebJsoup nikewJs = new NikeWebJsoup();
//        List<String> todayDrawList = nikewJs.getTodayDrawList();

        SendMessage telegram = new SendMessage();
        telegram.sendTelegram();
    }
}
