package com.project.spring.common.crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;


import java.io.IOException;
@Component
public class Test33 {

    public String findImage() {
        String URL = "https://www.mangoplate.com/search/한일관" ;
//        String URL = "https://search.naver.com/search.naver?where=image&sm=tab_jum&query=%EB%9E%98%EB%AF%B8%EC%95%88%EB%8F%84%EA%B3%A1%EC%B9%B4%EC%9A%B4%ED%8B%B0";

        String imageSrc;
        Document doc;
        {
            try {
                doc = Jsoup.connect(URL).get();
                Element elem = doc.select(".thumb > img").get(0);
                imageSrc = elem.attr("data-original");
                    return imageSrc;

//                doc = Jsoup.connect(URL).get();
//                Elements elem = doc.select("span[class=\"thumb\"]");
////                Element elem = doc.select(".thumb > img").get(0);
////                Element elem = doc;
//                imageSrc = elem.attr("src");
//                System.out.println(elem);
//                return imageSrc;


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }





    }

}
