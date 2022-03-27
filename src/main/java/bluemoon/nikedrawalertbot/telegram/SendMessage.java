package bluemoon.nikedrawalertbot.telegram;

import bluemoon.nikedrawalertbot.config.Config;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class SendMessage {

    public void sendTelegram(List<String> drawList) {
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
