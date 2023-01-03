DROP TABLE "USER";
DROP TABLE "RESERVATION";
DROP TABLE "RESERVATION_M";
DROP TABLE "CULTURAL_FACILITY";
DROP TABLE "PHYSCICAL_FACILITY";

create table "USER"
(
    USER_NO    NUMBER        not null
        constraint PK_MEMBER
            primary key,
    USER_EMAIL VARCHAR2(100) not null,
    USER_NAME  VARCHAR2(100) not null,
    ADDRESS    VARCHAR2(255),
    INTEREST   VARCHAR2(100),
    SEARCH     VARCHAR2(100)
);

comment on column "USER".USER_NO is '회원번호';

comment on column "USER".USER_EMAIL is '이메일';

comment on column "USER".USER_NAME is '닉네임';

comment on column "USER".ADDRESS is '주소';

comment on column "USER".INTEREST is '관심사';

comment on column "USER".SEARCH is '최근검색';

create table PHYSICAL_FACILITY
(
    SVCID       VARCHAR2(255) not null
        constraint PK_PHYSCICAL_FACILITY
        primary key,
    MINCLASSNM  VARCHAR2(50)  not null,
    SVCSTATNM   VARCHAR2(50)  not null,
    SVCNM       VARCHAR2(255) not null,
    PLACENM     VARCHAR2(100) not null,
    X           VARCHAR2(80),
    Y           VARCHAR2(80),
    RCPTBGNDT   VARCHAR2(255),
    RCPTENDDT   VARCHAR2(255),
    AREANM      VARCHAR2(50),
    TELNO       VARCHAR2(50),
    REVSTDDAY   VARCHAR2(255),
    SVCURL      VARCHAR2(255),
    SVCOPNBGNDT VARCHAR2(100),
    SVCOPNENDDT VARCHAR2(100)
);

comment on column PHYSICAL_FACILITY.SVCID is '서비스ID';

comment on column PHYSICAL_FACILITY.MINCLASSNM is '소분류명';

comment on column PHYSICAL_FACILITY.SVCSTATNM is '서비스상태';

comment on column PHYSICAL_FACILITY.SVCNM is '서비스명';

comment on column PHYSICAL_FACILITY.PLACENM is '장소명';

comment on column PHYSICAL_FACILITY.X is '장소X좌표';

comment on column PHYSICAL_FACILITY.Y is '장소Y좌표';

comment on column PHYSICAL_FACILITY.RCPTBGNDT is '접수시작일시';

comment on column PHYSICAL_FACILITY.RCPTENDDT is '접수종료일시';

comment on column PHYSICAL_FACILITY.AREANM is '지역명';

comment on column PHYSICAL_FACILITY.TELNO is '전화번호';

comment on column PHYSICAL_FACILITY.REVSTDDAY is '취소기간 기준일';

comment on column PHYSICAL_FACILITY.SVCURL is '이미지경로';

comment on column PHYSICAL_FACILITY.SVCOPNBGNDT is '서비스개시시작일시';

comment on column PHYSICAL_FACILITY.SVCOPNENDDT is '서비스개시종료일시';

create table CULTURAL_FACILITY
(
    SVCID       VARCHAR2(255) not null
        constraint PK_CULTURAL_FACILITY
        primary key,
    MINCLASSNM  VARCHAR2(50)  not null,
    SVCSTATNM   VARCHAR2(50)  not null,
    SVCNM       VARCHAR2(255) not null,
    PLACENM     VARCHAR2(100) not null,
    X           VARCHAR2(80),
    Y           VARCHAR2(80),
    RCPTBGNDT   VARCHAR2(255),
    RCPTENDDT   VARCHAR2(255),
    AREANM      VARCHAR2(50),
    TELNO       VARCHAR2(50),
    REVSTDDAY   VARCHAR2(255),
    SVCURL      VARCHAR2(255),
    SVCOPNBGNDT VARCHAR2(100),
    SVCOPNBGDDT VARCHAR2(100)
);

comment on column CULTURAL_FACILITY.SVCID is '서비스ID';

comment on column CULTURAL_FACILITY.MINCLASSNM is '소분류명';

comment on column CULTURAL_FACILITY.SVCSTATNM is '서비스상태';

comment on column CULTURAL_FACILITY.SVCNM is '서비스명';

comment on column CULTURAL_FACILITY.PLACENM is '장소명';

comment on column CULTURAL_FACILITY.X is '장소X좌표';

comment on column CULTURAL_FACILITY.Y is '장소Y좌표';

comment on column CULTURAL_FACILITY.RCPTBGNDT is '접수시작일시';

comment on column CULTURAL_FACILITY.RCPTENDDT is '접수종료일시';

comment on column CULTURAL_FACILITY.AREANM is '지역명';

comment on column CULTURAL_FACILITY.TELNO is '전화번호';

comment on column CULTURAL_FACILITY.REVSTDDAY is '취소기간 기준일까지';

comment on column CULTURAL_FACILITY.SVCURL is '이미지경로';

comment on column CULTURAL_FACILITY.SVCOPNBGNDT is '서비스개시시작일시';

comment on column CULTURAL_FACILITY.SVCOPNBGDDT is '서비스개시종료일시';

create table RESERVATION
(
    RE_ID     VARCHAR2(100)        not null,
    USER_NO   NUMBER               not null,
    RE_DATE   DATE default SYSDATE not null,
    CATEGORY  VARCHAR2(100)        not null,
    SVCID     VARCHAR2(100)        not null,
    RE_STATUS VARCHAR2(50)         not null,
    SVCNM     VARCHAR2(255),
    PLACENM   VARCHAR2(100)
);

comment on column RESERVATION.RE_ID is '예약번호';

comment on column RESERVATION.USER_NO is '회원번호';

comment on column RESERVATION.RE_DATE is '예약일자';

comment on column RESERVATION.CATEGORY is '시설대분류';

comment on column RESERVATION.SVCID is '서비스ID';

comment on column RESERVATION.RE_STATUS is '예약상태';

comment on column RESERVATION.SVCNM is '서비스명';

comment on column RESERVATION.PLACENM is '장소명';

CREATE SEQUENCE  "SPRINGP"."SEQ_RE_NO"  MINVALUE 1 MAXVALUE 20000 INCREMENT BY 1 START WITH 5000 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
CREATE SEQUENCE  "SPRINGP"."SEQ_UNO"  MINVALUE 1 MAXVALUE 10000 INCREMENT BY 1 START WITH 1000 CACHE 20 NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
