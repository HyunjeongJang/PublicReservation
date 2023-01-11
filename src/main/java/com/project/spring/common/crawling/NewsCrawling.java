package com.project.spring.common.crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

public class NewsCrawling {
    public static void main(String[] args) {

        String URL = "https://news.naver.com/main/list.nhn?mode=LS2D&sid2=263&sid1=101&mid=shm&date=20190612&page=1";
        Document doc;

        try {
            doc = Jsoup.connect(URL).get();
            Elements elem  = doc.select("div[class=\"list_body newsflash_body\"]");



            for(Element e: elem.select("dt")){
//                for(Element a:elem.select("dd")){
                    if(e.className().equals("photo")){
                        continue;
                    }
//                    System.out.println(e.text()+"\n"+a.text());
                    System.out.println(e.getElementsByAttribute("href"));
//                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
