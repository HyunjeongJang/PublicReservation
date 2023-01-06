package com.project.spring.facility.service;

import com.project.spring.client.seoulapi.SeoulApiClient;
import com.project.spring.common.PageInfo;
import com.project.spring.facility.entity.CultureFacility;
import com.project.spring.facility.repository.CultureRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CultureServiceImpl implements CultureService {

    private final CultureRepository cultureRepository;
    private final SeoulApiClient seoulApiClient;


    private final SqlSession sqlSession;


    //생성자 주입
    @Autowired
    public CultureServiceImpl(CultureRepository cultureRepository, SeoulApiClient seoulApiClient, SqlSession sqlSession) {
        this.cultureRepository = cultureRepository;
        this.seoulApiClient = seoulApiClient;

        this.sqlSession = sqlSession;
    }



    // ReservationCulture 목록을 새롭게 조회해서 데이터베이스에 넣어준다.
    public int retrieveAndSave() {
        List<CultureFacility> cultures = seoulApiClient.getReservationCultureList()
            .stream()
            // .map(culture -> CultureFacility.of(culture))
            .map(CultureFacility::of)// Lambda 가 아니라 메소드참조 형태로 들어간 부분
            .collect(Collectors.toList());

        cultureRepository.truncate();
        cultureRepository.batchInsert(cultures);
        return cultures.size();
    }



//    @Override
//    public List<CultureFacility> selectCulturelist() throws Exception {
//        return cultureRepository.selectCulturelist();
//    }




    @Override
    public int selectListCount() {
        return cultureRepository.selectListCount();
    }

    @Override
    public ArrayList<CultureFacility> selectList(PageInfo pi){
        return cultureRepository.selectList(pi);
    }







}
