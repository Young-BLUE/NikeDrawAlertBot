package bluemoon.nikedrawalertbot;

import bluemoon.nikedrawalertbot.jsoup.nikeWeb.NikeWebJsoup;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NikeDrawAlertBotApplication {

    public static void main(String[] args) throws IOException {
//        SpringApplication.run(NikeDrawAlertBotApplication.class, args);
        NikeWebJsoup nikewJs = new NikeWebJsoup();
        nikewJs.getTodayDrawList();
    }


}
