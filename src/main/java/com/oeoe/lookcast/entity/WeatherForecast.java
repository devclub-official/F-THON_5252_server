package com.oeoe.lookcast.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "weather_forecast")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeatherForecast {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "request_id", nullable = false)
  private OutfitRequest request;

  private Boolean isDestination;  // false: 현재 위치, true: 목적지
  private LocalDateTime forecastTime;
  private Double temperature;
  private String weatherStatus;
  private Double humidity;
  private Double precipitation;
  private Double windSpeed;

  @Column(updatable = false)
  private LocalDateTime createdAt;

  @PrePersist
  protected void onCreate() {
    createdAt = LocalDateTime.now();
  }
}