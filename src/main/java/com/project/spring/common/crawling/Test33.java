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


        String URL = "https://www.mangoplate.com/search/%ED%99%8D%EC%BD%A9%EB%B0%98%EC%A0%90";

        String imageSrc;

        Document doc;

        {
            try {
                doc = Jsoup.connect(URL).get();
                Element elem = doc.select(".thumb > img").get(0);
                imageSrc = elem.attr("data-original");
                    return imageSrc;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
