package com.oeoe.lookcast.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 코디 추천 응답 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutfitRecommendationResponseDTO {
    private Long requestId;
    private UserInfoDTO userInfo;
    private LocationDTO currentLocation;
    private LocationDTO destinationLocation;
    private String purpose;
    private LocalDateTime requestTime;
    private WeatherDTO destinationWeather;
    private List<OutfitDTO> recommendedOutfits;
}