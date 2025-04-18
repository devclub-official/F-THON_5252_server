package com.oeoe.lookcast.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 날씨 정보 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherDTO {
    private LocalDateTime forecastTime;
    private BigDecimal temperature;
    private String weatherStatus;
    private BigDecimal humidity;
    private BigDecimal windSpeed;
}