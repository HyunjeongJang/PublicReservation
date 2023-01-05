package com.project.spring.client.seoulapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor  // 기본생성자
@AllArgsConstructor  // 모든 인스턴스 변수를 받는 생성자
@ToString
public class ReservationCultureDto { // 서울 OpenAPI 에서 받아온 데이터 저장하기위한 client쪽 dto

	@JsonProperty("SVCID")
	private String serviceId;
	@JsonProperty("MAXCLASSNM")
	private String maxClassName;  // ObjectMapper
	@JsonProperty("MINCLASSNM")
	private String minClassName;
	@JsonProperty("SVCSTATNM")
	private String serviceState;
	@JsonProperty("SVCNM")
	private String serviceName;
	@JsonProperty("PLACENM")
	private String placeName;
	@JsonProperty("USERTGTINFO")
	private String useTargetInfo;
	@JsonProperty("SVCURL")
	private String serviceUrl;
	@JsonProperty("X")
	private String x;
	@JsonProperty("Y")
	private String y;
	@JsonProperty("SVCOPNBGNDT")
	private String serviceOpenBeginDate;
	@JsonProperty("SVCOPNENDDT")
	private String serviceOpenEndDate;
	@JsonProperty("RCPTBGNDT")
	private String rcptBeginDate;
	@JsonProperty("RCPTENDDT")
	private String rcptEndDate;
	@JsonProperty("AREANM")
	private String areaName;
	@JsonProperty("IMGURL")
	private String imgUrl;
	@JsonProperty("TELNO")
	private String tel;
	@JsonProperty("V_MIN")
	private String vMin;
	@JsonProperty("V_MAX")
	private String vMax;
	@JsonProperty("REVSTDDAY")
	private String revStdDay;

}
