package com.project.spring.facility.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class Reply {

    private int replyNo;
    private String replyContent;
    private int refSvcId;
    private String replyWriter;
    private Date createDate;
    private String status;

}
