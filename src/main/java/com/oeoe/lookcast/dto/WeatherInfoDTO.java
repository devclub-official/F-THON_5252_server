package com.oeoe.lookcast.dto;

import lombok.*;

import java.time.LocalDateTime;

/**
 * 날씨 정보 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class WeatherInfoDTO {

  private Long id;
  private Long requestId;            // 연관된 요청 ID
  private Boolean isDestination;     // 목적지 여부 (false: 현재 위치, true: 목적지)
  private LocalDateTime forecastTime; // 예보 시간
  private Double temperature;        // 온도 (섭씨)
  private String weatherStatus;      // 날씨 상태 (맑음, 흐림, 비 등)
  private Double humidity;           // 습도 (%)
  private Double precipitation;      // 강수 확률 (%)
  private Double windSpeed;          // 풍속 (m/s)
}