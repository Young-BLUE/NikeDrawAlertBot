package bluemoon.nikedrawalertbot.jsoup.nikeWeb;

import java.io.IOException;
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

    public String getTodayDrawList() throws IOException {

        final String drawList = "https://www.nike.com/kr/launch/?type=upcoming";
        Connection conn = Jsoup.connect(drawList);
        Document document = conn.get();
//        try{
//            List<Element> drawShoesList = new ArrayList<>();
//            Document document = conn.get();
//            Elements elements = document.select("[data-active-date]");
//            for(Element e : elements) {
//                if(e.text().contains("응모 시작")){
//                    drawShoesList.add(e);
//                }
//            }
//        } catch(Exception e) {
//            log.error(String.valueOf(e));
//        }
//
//        return drawList;
        System.out.println(document);
        return String.valueOf(document);
    }

}
