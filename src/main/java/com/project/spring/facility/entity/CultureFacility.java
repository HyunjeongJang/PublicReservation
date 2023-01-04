package com.project.spring.facility.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.project.spring.client.seoulapi.dto.ReservationCultureDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CultureFacility {

	private long id; // 1, 2, 3, 4, 5, 6, 7,,,
	private String serviceId; // SVC(PK)
	private String minClassName;
	private String serviceState;
	private String serviceName;
	private String placeName;
	private String x;
	private String y;
	private String serviceOpenBeginDate;
	private String serviceOpenEndDate;
	private String rcptBeginDate;
	private String rcptEndDate;
	private String areaName;
	private String tel;
	private String serviceUrl;
	private String revStdDay;

	// 팩토리 메소드 -> 객체 생성을 위한 메소드
	// Builder 패턴 -> 객체 생성을 위한 디자인패턴
	public static CultureFacility of(ReservationCultureDto culture) {
		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		// LocalDateTime time = LocalDateTime.parse(~~~~, formatter);

		return CultureFacility.builder()
			.serviceId(culture.getServiceId())
			.minClassName(culture.getMinClassName())
			.serviceState(culture.getServiceState())
			.serviceName(culture.getServiceName())
			.placeName(culture.getPlaceName())
			.x(culture.getX())
			.y(culture.getY())
			.serviceOpenBeginDate(culture.getServiceOpenBeginDate())
			.serviceOpenEndDate(culture.getServiceOpenEndDate())
			.rcptBeginDate(culture.getRcptBeginDate())
			.rcptEndDate(culture.getRcptEndDate())
			.areaName(culture.getAreaName())
			.tel(culture.getTel())
			.serviceUrl(culture.getServiceUrl())
			.revStdDay(culture.getRevStdDay())
			.build();
	}

}
