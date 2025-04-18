package com.oeoe.lookcast.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 사용자의 코디 추천 요청 정보 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OutfitRequestDTO {
  private Long id;
  private String gender;              // 성별 (male, female)
  private Integer age;                // 나이
  private String stylePreference;     // 선호 스타일 (캐주얼, 모던 등)
  private String purpose;             // 목적 (데이트, 출근, 여행 등)

  // 현재 위치 정보
  private Double currentLatitude;     // 현재 위치 위도
  private Double currentLongitude;    // 현재 위치 경도
  private String currentLocationName; // 현재 위치 이름

  // 목적지 정보
  private Double destinationLatitude;     // 목적지 위도
  private Double destinationLongitude;    // 목적지 경도
  private String destinationLocationName; // 목적지 이름

  private LocalDateTime requestTime;      // 요청 시간
}