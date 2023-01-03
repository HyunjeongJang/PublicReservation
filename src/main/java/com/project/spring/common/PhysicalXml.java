package com.project.spring.common;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import com.project.spring.facility.dto.GovDataDTO;
import com.project.spring.facility.service.CultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PhysicalXml {

    private CultureService cultureService;

    @Autowired
    public PhysicalXml(CultureService cultureService) {
        this.cultureService = cultureService;
    }





    public static String getTagValue(String tag, Element eElement) {
        //결과를 저장할 result 변수 선언
        String result = "";
        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
        result = nlList.item(0).getTextContent();
        return result;
    }

    // tag값의 정보를 가져오는 함수
    public static String getTagValue(String tag, String childTag, Element eElement) {

        //결과를 저장할 result 변수 선언
        String result = "";

        NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();

        for(int i = 0; i < eElement.getElementsByTagName(childTag).getLength(); i++) {

            //result += nlList.item(i).getFirstChild().getTextContent() + " ";
            result += nlList.item(i).getChildNodes().item(0).getTextContent() + " ";
        }

        return result;
    }

    public static void main(String[] args) {

        String key = "795879565873756b35317079716c52";
        // parsing할 url 지정(API 키 포함해서)

        try {

            String url = "http://openAPI.seoul.go.kr:8088/"+key+"/xml/ListPublicReservationSport/1/5/";
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = null;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(url);

            // 제일 첫번째 태그
//            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName()); // Root element: result

            // 파싱할 tag
            NodeList nList = doc.getElementsByTagName("row");

            for(int temp = 0; temp < nList.getLength(); temp++){
                Node nNode = nList.item(temp);

                Element eElement = (Element) nNode;

                String svcid = getTagValue("SVCID", eElement);
                String minClassNm = getTagValue("MINCLASSNM", eElement);
                String svcStatNm = getTagValue("SVCSTATNM", eElement);
                String svcNm = getTagValue("SVCNM", eElement);
                String placeNm = getTagValue("PLACENM", eElement);
                String x = getTagValue("X", eElement);
                String y = getTagValue("Y", eElement);
                String rcptBgnDt = getTagValue("RCPTBGNDT", eElement);
                String rcptEndDt = getTagValue("RCPTENDDT", eElement);
                String areaNm = getTagValue("AREANM", eElement);
                String telNo = getTagValue("TELNO", eElement);
                String revStdDay = getTagValue("REVSTDDAYNM", eElement);
                String svcUrl = getTagValue("REVSTDDAY", eElement);

                GovDataDTO list = new GovDataDTO();
                list.setSvcId(svcid);
                list.setMinClassNm(minClassNm);
                list.setSvcStatNm(svcStatNm);
                list.setSvcNm(svcNm);
                list.setPlaceNm(placeNm);
                list.setX(x);
                list.setY(y);
                list.setRcptBgnDt(rcptBgnDt);
                list.setRcptEndDt(rcptEndDt);
                list.setAreaNm(areaNm);
                list.setTelNo(telNo);
                list.setRevStdDay(revStdDay);
                list.setSvcUrl(svcUrl);



            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//                System.out.println("서비스코드 : " + svcid);
//                System.out.println("소분류명 : " + minClassNm);
//                System.out.println("서비스 상태 : " + svcStatNm);
//                System.out.println("서비스명 : " + svcNm);
//                System.out.println("장소명 : " + placeNm);
//                System.out.println("x좌표 : " + x);
//                System.out.println("y좌표 : " + y);
//                System.out.println("접수시작일시 : " + rcptBgnDt);
//                System.out.println("접수종료일시 : " + rcptEndDt);
