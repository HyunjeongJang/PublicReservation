package com.project.spring.common;

import com.project.spring.facility.service.PhysicalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.*;

@Component
public class PhysicalInfoExplorer {

    private static final Logger logger = LoggerFactory.getLogger(PhysicalInfoExplorer.class);

    @Autowired
    private PhysicalService physicalService;

    public PhysicalInfoExplorer(PhysicalService physicalService) {
        this.physicalService = physicalService;
    }


    public void update(){
        int result = 0;
        List<Map<String, String>> list = new ArrayList<>();

        try {
            // 학원 목록 읽어오기
            createDocument(list);
            result += physicalService.PhysicalDB(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("총 갯수 :" + result);
    }

    //tag값 정보를 가져오는 메소드
    private static String getTagValue(String tag, Element eElement) {
        NodeList nList = null;
        Node nValue = null;
        try {
            nList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
            nValue = (Node) nList.item(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (nValue == null)
            return null;
        return nValue.getNodeValue();
    }


    private void parseXml(Element root, List<Map<String, String>> list) {
//        NodeList nList = root.getElementsByTagName("row").item(0).getChildNodes();
            NodeList nList = root.getElementsByTagName("row");
        System.out.println(nList.getLength());
        for (int i = 0; i < nList.getLength(); i++) {
            Map<String, String> map = new HashMap<>();
            Node nNode = nList.item(i);
            Element eElement = (Element) nNode;

            map.put("svcid", getTagValue("SVCID", eElement)); // 과정코드
            map.put("minClassNm", getTagValue("MINCLASSNM", eElement)); // 과정명
            map.put("svcStatNm", getTagValue("SVCSTATNM", eElement)); // 학원코드
            map.put("svcNm", getTagValue("SVCNM", eElement)); // 학원명
            map.put("placeNm", getTagValue("PLACENM", eElement)); // 학원 전화번호
            map.put("x", getTagValue("X", eElement)); // 훈련시작일자
            map.put("y", getTagValue("Y", eElement)); // 훈련종료일자
            map.put("svcOpnBgnDt",getTagValue("SVCOPNBGNDT",eElement));
            map.put("svcOpnEnDdt",getTagValue("SVCOPNENDDT",eElement));
            map.put("rcptBgnDt", getTagValue("RCPTBGNDT", eElement)); // 훈련대상
            map.put("rcptEndDt", getTagValue("RCPTENDDT", eElement)); // 정원
            map.put("areaNm", getTagValue("AREANM", eElement)); // 수강비
            map.put("telNo", getTagValue("TELNO", eElement)); // 실제 수강비
            map.put("imgUrl", getTagValue("IMGURL", eElement)); // 회차
            map.put("revStdDay", getTagValue("REVSTDDAY", eElement)); // 회차

//            System.out.println(map);
            list.add(map);
        }
    }

    private void createDocument(List<Map<String, String>> list) {

        String key = "795879565873756b35317079716c52";

        try {
            // URL 설정
            String url = "http://openAPI.seoul.go.kr:8088/"+key+"/xml/ListPublicReservationSport/1/1000";
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = null;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(url);

            doc.getDocumentElement().normalize();

            // 목록 정보 데이터 파싱하기
            parseXml(doc.getDocumentElement(), list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
