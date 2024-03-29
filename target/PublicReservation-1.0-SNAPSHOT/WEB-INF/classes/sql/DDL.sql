DROP TABLE SPRINGP.MEMBER;
DROP TABLE SPRINGP.RESERVATION;
DROP TABLE SPRINGP.CULTURAL_FACILITY;
DROP TABLE SPRINGP.PHYSICAL_FACILITY;

CREATE TABLE "SPRINGP"."MEMBER"
(
    "USER_NO"       NUMBER,
    "PROVIDER"      VARCHAR2(100),
    "PROVIDER_ID"   VARCHAR2(100),
    "USERNAME"      VARCHAR2(100),
    "EMAIL"         VARCHAR2(100),
    "PROFILE_IMAGE" VARCHAR2(512),
    "ADDRESS"       VARCHAR2(255),
    "INTEREST"      VARCHAR2(100),
    "LATEST_SEARCH" VARCHAR2(100)
);

CREATE TABLE "SPRINGP"."RESERVATION"
(
    "RE_ID"     VARCHAR2(100 BYTE),
    "USER_NO"   NUMBER,
    "RE_DATE"   DATE DEFAULT SYSDATE,
    "CATEGORY"  VARCHAR2(100 BYTE),
    "SVCID"     VARCHAR2(100 BYTE),
    "RE_STATUS" VARCHAR2(50 BYTE)
);

CREATE TABLE "SPRINGP"."CULTURAL_FACILITY"
(
    "SVCID"      VARCHAR2(255 BYTE),
    "MINCLASSNM" VARCHAR2(255 BYTE),
    "SVCSTATNM"  VARCHAR2(255 BYTE),
    "SVCNM"      VARCHAR2(255 BYTE),
    "PLACENM"    VARCHAR2(255 BYTE),
    "X"          VARCHAR2(255 BYTE),
    "Y"          VARCHAR2(255 BYTE),
    "SVCOPNBGNDT"  VARCHAR2(255 BYTE),
    "SVCOPNENDDT"  VARCHAR2(255 BYTE),
    "RCPTBGNDT"  VARCHAR2(255 BYTE),
    "RCPTENDDT"  VARCHAR2(255 BYTE),
    "AREANM"     VARCHAR2(255 BYTE),
    "TELNO"      VARCHAR2(255 BYTE),
    "IMGURL"     VARCHAR2(255 BYTE),
    "REVSTDDAY"  VARCHAR2(255 BYTE)
);

CREATE TABLE "SPRINGP"."PHYSICAL_FACILITY"
(
    "SVCID"      VARCHAR2(255 BYTE),
    "MINCLASSNM" VARCHAR2(255 BYTE),
    "SVCSTATNM"  VARCHAR2(255 BYTE),
    "SVCNM"      VARCHAR2(255 BYTE),
    "PLACENM"    VARCHAR2(255 BYTE),
    "X"          VARCHAR2(255 BYTE),
    "Y"          VARCHAR2(255 BYTE),
    "SVCOPNBGNDT"  VARCHAR2(255 BYTE),
    "SVCOPNENDDT"  VARCHAR2(255 BYTE),
    "RCPTBGNDT"  VARCHAR2(255 BYTE),
    "RCPTENDDT"  VARCHAR2(255 BYTE),
    "AREANM"     VARCHAR2(255 BYTE),
    "TELNO"      VARCHAR2(255 BYTE),
    "IMGURL"     VARCHAR2(255 BYTE),
    "REVSTDDAY"  VARCHAR2(255 BYTE)
);



-- create sequence SPRINGP.SEQ_RE_NO;
-- create sequence SPRINGP.SEQ_UNO
