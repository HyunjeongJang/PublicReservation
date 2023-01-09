package com.project.spring.common.crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;


import java.io.IOException;
@Component
public class Test33 {



//    public String findImage() {

    public static void main(String[] args) {


        String URL = "https://search.naver.com/search.naver?where=image&sm=tab_jum&query=홍콩반점";

        String imageSrc;

        Document doc;

        {
            try {
                doc = Jsoup.connect(URL).get();
//                Elements elem = doc.select("span[class=\"thumb\"]");
                Element elem = doc;
//                imageSrc = elem.attr("src");
                System.out.println(elem);
//                return imageSrc;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
