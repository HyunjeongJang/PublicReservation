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
public class ListPublicReservationCulture {

	@JsonProperty("row")
	private ReservationCultureDto[] cultures;

}
