package com.project.spring.facility.entity;

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

	private String svcId; // SVC(PK)
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
	private String imgUrl;
	private String revStdDay;

	// 팩토리 메소드 -> 객체 생성을 위한 메소드
	// Builder 패턴 -> 객체 생성을 위한 디자인패턴
	public static CultureFacility of(ReservationCultureDto culture) {
		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		// LocalDateTime time = LocalDateTime.parse(~~~~, formatter);

		return CultureFacility.builder()
			.svcId(culture.getSvcId())
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
			.imgUrl(culture.getImgUrl())
			.revStdDay(culture.getRevStdDay())
			.build();
	}

}
