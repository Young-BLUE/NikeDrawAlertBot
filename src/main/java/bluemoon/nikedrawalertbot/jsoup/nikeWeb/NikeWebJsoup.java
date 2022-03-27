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
@Component
public class NikeWebJsoup {

    public List<String> getTodayDrawList() {

        final String drawURL = "https://www.nike.com/kr/launch/?type=upcoming";
        Connection conn = Jsoup.connect(drawURL);
        List<String> drawList = new ArrayList<>();

        try {
            Document document = conn.get();
            Elements contents = document.select(".figcaption-content");

            if (contents.size() > 0) {
                // 가져온 상품명 목록 태그로부터 상품명, 출시시간, 상품링크를 추출
                for (Element e : contents) {
                    if(e.select("a").text().contains("DRAW")) {
                        StringBuilder sb = new StringBuilder();

                        sb.append(e.select("h3").text() + "%0A"); // 예정시간
                        sb.append(e.select("h6").text() + "%0A"); // 상품명
                        sb.append("https://www.nike.com/" + e.select("a").attr("href")); // 상품 URL

                        drawList.add(sb.toString());
                    }
                }
            } else {
                log.info(new SimpleDateFormat("yyyy-MM-dd").format(ZonedDateTime.now(ZoneId.of("Asia/Seoul")))
                         + " - 상품이 없습니다.");
            }
        } catch (IOException ie) {
            log.error(String.valueOf(ie));
        }
        return drawList;
    }

}
