package com.project.spring.facility.service;

import com.project.spring.client.seoulapi.SeoulApiClient;
import com.project.spring.common.PageInfo;
import com.project.spring.facility.dto.CultureFacilityBoardRequest;
import com.project.spring.facility.dto.CultureFacilityBoardResponse;
import com.project.spring.facility.entity.CultureFacility;
import com.project.spring.facility.repository.CultureRepository;
import com.project.spring.facility.repository.filter.CultureFacilityFilter;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CultureServiceImpl implements CultureService {

    private static final int DEFAULT_BOARD_SIZE = 12;

    private final CultureRepository cultureRepository;
    private final SeoulApiClient seoulApiClient;

//    private final SqlSession sqlSession; // 등록해놔서 안만들어도 가져올 수 있음

    //생성자 주입
    @Autowired
    public CultureServiceImpl(CultureRepository cultureRepository, SeoulApiClient seoulApiClient,
                              SqlSession sqlSession) {
        this.cultureRepository = cultureRepository;
        this.seoulApiClient = seoulApiClient;

//        this.sqlSession = sqlSession;
    }

    // ReservationCulture 목록을 새롭게 조회해서 데이터베이스에 넣어준다.
    public int retrieveAndSave() {
        List<CultureFacility> cultures = seoulApiClient.getReservationCultureList()
                .stream()
                // .map(culture -> CultureFacility.of(culture))
//                .filter(culture -> culture.getServiceState().equals("접수중"))
                .map(CultureFacility::of)// Lambda 가 아니라 메소드참조 형태로 들어간 부분
                .collect(Collectors.toList());

        cultureRepository.truncate();
        cultureRepository.batchInsert(cultures);
        return cultures.size();
    }


    @Override
    public int selectListCount() {
        return cultureRepository.selectListCount();
    }


//    페이징처리
//    @Override
//    public CultureFacilityBoardResponse selectList(CultureFacilityBoardRequest request) {
//        // 1. 총 CultureFacility 개수를 가져온다.
//        int count = cultureRepository.selectListCount();
//        // 2. PageInfo 객체를 생성한다.
//        PageInfo pageInfo = new PageInfo(count, currentPage, DEFAULT_BOARD_SIZE);
//        // 3. PageInfo 객체를 이용해 CultureFacility 목록을 가져와 반환한다.
//        List<CultureFacility> result = cultureRepository.selectList(pageInfo);
//        return new CultureFacilityBoardResponse(result, pageInfo);
//    }


    @Override
    public CultureFacilityBoardResponse selectList(CultureFacilityBoardRequest request) {
        // 1. 총 CultureFacility 개수를 가져온다.
        int count = cultureRepository.selectListCount();
        // 2. PageInfo 객체를 생성한다.
        PageInfo pageInfo = new PageInfo(count, request.getCurrentPage(), DEFAULT_BOARD_SIZE);
        // 3. PageInfo 객체를 이용해 CultureFacility 목록을 가져와 반환한다.
        List<CultureFacility> result = cultureRepository.selectList(pageInfo, CultureFacilityFilter.from(request));
        return new CultureFacilityBoardResponse(result, pageInfo);
    }

    @Override
    public CultureFacility cultureDetail(String svcId) {
        return cultureRepository.cultureDetail(svcId);
    }

    @Override
    public List<CultureFacility> recommendCultureList() {
        return cultureRepository.recommendCultureList();
    }

}
