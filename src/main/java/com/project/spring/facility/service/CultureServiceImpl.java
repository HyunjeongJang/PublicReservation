package com.project.spring.facility.service;

import com.project.spring.client.seoulapi.SeoulApiClient;
import com.project.spring.client.seoulapi.dto.ReservationCultureDto;
import com.project.spring.facility.dto.GovDataDTO;
import com.project.spring.facility.entity.CultureFacility;
import com.project.spring.facility.repository.CultureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CultureServiceImpl implements CultureService {

    private final CultureRepository cultureRepository;
    private final SeoulApiClient seoulApiClient;

    //생성자 주입
    @Autowired
    public CultureServiceImpl(CultureRepository cultureRepository, SeoulApiClient seoulApiClient) {
        this.cultureRepository = cultureRepository;
        this.seoulApiClient = seoulApiClient;
    }

    // ReservationCulture 목록을 새롭게 조회해서 데이터베이스에 넣어준다.
    public int retrieveAndSave() {
        List<CultureFacility> cultures = seoulApiClient.getReservationCultureList()
            .stream()
            // .map(culture -> CultureFacility.of(culture))
            .map(CultureFacility::of)// Lambda 가 아니라 메소드참조 형태로 들어간 부분
            .collect(Collectors.toList());

        /**
         *  BatchInsert & BulkInsert
         *  INSERT INTO [ ] VALUES ( ), ( ), ( ), ( ),,
         */
        cultureRepository.truncate();
        cultureRepository.batchInsert(cultures);
        return cultures.size();
    }

    @Override
    public void insertInfo(GovDataDTO govDataDTO) {
        cultureRepository.insertInfo(govDataDTO);
    }

    @Override
    public List<GovDataDTO> cultureList() {
        return cultureRepository.cultureList();
    }

}
