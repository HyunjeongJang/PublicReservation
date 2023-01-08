package com.project.spring.facility.repository;

import com.project.spring.facility.dto.Reply;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReplyRepository {

    private final SqlSessionTemplate sqlSession;

    public List<Reply> selectReplyList(String svcId) {
        return sqlSession.selectList("boardMapper.selectReplyList", svcId);
    }

    public int insertReply(Reply r) {
        return sqlSession.insert("replyMapper.insertReply",r);
    }

}
