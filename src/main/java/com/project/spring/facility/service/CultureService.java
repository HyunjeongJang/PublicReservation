package com.project.spring.facility.service;

import com.project.spring.facility.dto.GovDataDTO;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public interface CultureService {
    void insertInfo(GovDataDTO govDataDTO) throws IOException, ParserConfigurationException, SAXException;

    List<GovDataDTO> cultureList();
    int retrieveAndSave();
}
