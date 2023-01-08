package com.project.spring.facility.service;

import com.project.spring.facility.dto.Reply;
import com.project.spring.facility.repository.ReplyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {

    private ReplyRepository replyRepository;


    public List<Reply> selectReplyList(String svcId) {
        return replyRepository.selectReplyList(svcId);
    }

    public int insertReply(Reply r) {
        return replyRepository.insertReply(r);
    }
}
