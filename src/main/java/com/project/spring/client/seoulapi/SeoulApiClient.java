package com.project.spring.client.seoulapi;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.project.spring.client.seoulapi.dto.ReservationCultureDto;
import com.project.spring.client.seoulapi.dto.PublicReservationCultureResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SeoulApiClient {

	private final RestTemplate restTemplate;
	private static final String SEOUL_API_BASE_URL = "http://openAPI.seoul.go.kr:8088";
	private final String apiKey = "5466506d73616868373275546a7274";

	public List<ReservationCultureDto> getReservationCultureList() {
		String serviceName = "ListPublicReservationCulture";
		String url = this.generateUrl(serviceName, 1, 1000);

		try {
			PublicReservationCultureResponse response = restTemplate.getForObject(url, PublicReservationCultureResponse.class);
			if (response == null) {
				throw new RuntimeException(serviceName + " 조회 실패!");
			}
			return Arrays.asList(response.getCultures().getCultures());
		} catch (Exception ex) {
			throw new RuntimeException(serviceName + " 조회 실패!");
		}
	}

	private String generateUrl(String serviceName, int start, int end) {
		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append(SEOUL_API_BASE_URL);
		urlBuilder.append("/").append(apiKey);
		urlBuilder.append("/").append("json");
		urlBuilder.append("/").append(serviceName);
		urlBuilder.append("/").append(start);
		urlBuilder.append("/").append(end);
		return urlBuilder.toString();
	}

}
