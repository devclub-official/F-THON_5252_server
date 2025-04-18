package com.oeoe.lookcast.dto;

import lombok.*;

import java.util.List;

/**
 * 코디 추천 요청 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutfitRequestDTO {
    private UserInfoDTO userInfo;
    private LocationDTO currentLocation;
    private LocationDTO destinationLocation;
    private String purpose;
    private List<WeatherDTO> weatherForecasts;  // 현재 위치와 목적지의 날씨 정보
}