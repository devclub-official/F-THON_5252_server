package com.oeoe.lookcast.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OutfitRequestDTO {
  private Long id;
  private String gender;
  private Integer age;
  private String stylePreference;
  private String purpose;
  private Double currentLatitude;
  private Double currentLongitude;
  private String currentLocationName;
  private Double destinationLatitude;
  private Double destinationLongitude;
  private String destinationLocationName;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime requestTime;

  private WeatherData weather;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class WeatherData {
    private LocationWeather current;
    private LocationWeather destination;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class LocationWeather {
    private WeatherPoint current;
    private WeatherPoint after3h;
    private WeatherPoint after6h;
    private WeatherPoint after9h;
  }

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class WeatherPoint {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;
    private Double temp;
    private Double humidity;
    private String description;
    private Double windSpeed;
    private Double precipitation;
  }
}