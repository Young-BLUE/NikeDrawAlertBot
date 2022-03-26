package bluemoon.nikedrawalertbot.jsoup.nikeWeb;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
public class NikeWebJsoup {

    public String getTodayDrawList() {

        final String drawList = "https://www.nike.com/kr/launch/?type=upcoming";
        Connection conn = Jsoup.connect(drawList);
        Document document = null;
        try {
            document = conn.get();
            Elements contents = document.select(".figcaption-content");

            if (contents.size() > 0) {
                // 가져온 상품명 목록 태그로부터 상품명, 출시시간, 상품링크를 추출
                for (Element e : contents) {
                    System.out.println(e.getElementsByClass("headline-3").text());
                    System.out.println(e.getElementsByClass("headline-5").text());
                    System.out.println("https://www.nike.com/" + e.select("a").attr("href"));
                    System.out.println("");
                }
            } else {
                log.info(new SimpleDateFormat("yyyy-MM-dd").format(ZonedDateTime.now(ZoneId.of("Asia/Seoul")))
                         + " - 응모 가능한 상품이 없습니다.");
            }
        } catch (IOException ie) {
            log.error(String.valueOf(ie));
        }
        return String.valueOf(document);
    }

}
