package com.project.spring.facility.controller;

import com.project.spring.facility.dto.GovDataDTO;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CultureInfoExplorer {

    private static String getTagValue(String tag, Element eElement) {
        NodeList nList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nList.item(0);
        if (nValue == null) {
            return null;
        }
        return nValue.getNodeValue();
    }

    public List<GovDataDTO> parsingData(String searchName) throws IOException, ParserConfigurationException, SAXException {

        List<GovDataDTO> list = new ArrayList<GovDataDTO>();
        // "&pageNo=100&numOfRows=100"  갯수와 로우 100까지는 테스트 10000은 404에러
        String str = "";    //return을 위해서
        String parsingUrl = "";//Parsing할 URL
        String urlBuilder = "http://openAPI.seoul.go.kr:8088/5466506d73616868373275546a7274/xml/ListPublicReservationCulture/1/10/";

        URL url = new URL(urlBuilder);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());  // TODO : 여기까지 됨

        parsingUrl = url.toString();
        System.out.println(parsingUrl);

        //페이지에 접근해줄 Document객체 생성
        //doc객체를 통해 파싱할 url의 요소를 읽어들인다.
        //doc.getDocumentElement().getNodeName()을 출력하면 위 xml의 최상위 태그를 가져온다.
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(parsingUrl);

        // root tag
        doc.getDocumentElement().normalize();
        System.out.println("Root element: " + doc.getDocumentElement().getNodeName()); // Root element: result

        //파싱할 데이터  tag에 접근하는데 리스트 수 확인
        NodeList nList = doc.getElementsByTagName("item");
        System.out.println("파싱할 리스트 수 : " + nList.getLength());//파링할 리스트 수

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;

                GovDataDTO dto = new GovDataDTO();

                System.out.println("=================================");
                System.out.println(getTagValue("svcId", eElement));
                System.out.println(getTagValue("minClassNm", eElement));
                System.out.println(getTagValue("svcStatNm", eElement));
                System.out.println(getTagValue("svcNm", eElement));

                dto.setSvcId(getTagValue("svcId", eElement));
                dto.setMinClassNm(getTagValue("minClassNm", eElement));
                dto.setSvcStatNm(getTagValue("svcStatNm", eElement));
                dto.setSvcNm(getTagValue("svcNm", eElement));

                assert false;
                list.add(dto);
            }
        }

        return list;

    }
}
