package bluemoon.nikedrawalertbot.telegram;

import bluemoon.nikedrawalertbot.config.Config;
import bluemoon.nikedrawalertbot.jsoup.nikeWeb.NikeWebJsoup;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SendMessage {

    @Scheduled(cron = "0 0 9 * * *")
    public void sendTelegram() {
        // 이렇게 작성하면 의존성이 생기지만 @Scheduled를 사용하기 위해 적용
        NikeWebJsoup nike = new NikeWebJsoup();
        List<String> drawList = nike.getTodayDrawList();

        Config config = new Config();

        String myToken = config.getToken();
        String chatId = config.getId();

        BufferedReader bf = null;

        try {
            // 상품 수만큼 반복 문자 발송
            for(String draw : drawList) {
                URL obj = new URL("https://api.telegram.org/bot" + myToken + "/sendmessage?chat_id=" + chatId + "&text=" + draw);

                HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
                conn.setRequestMethod("GET");
                bf = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

                // 응답 출력
                String line;
                while((line = bf.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(bf != null) {
                try {
                    bf.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
