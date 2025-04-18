package com.oeoe.lookcast.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "weather_forecast")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherForecast {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "request_id", nullable = false)
  private OutfitRequest request;

  @Column(name = "is_destination", nullable = false)
  private Boolean isDestination;

  @Column(name = "forecast_time", nullable = false)
  private LocalDateTime forecastTime;

  @Column
  private Double temperature;

  @Column(name = "weather_status", length = 50)
  private String weatherStatus;

  @Column
  private Double humidity;

  @Column
  private Double precipitation;

  @Column(name = "wind_speed")
  private Double windSpeed;

  @Column(name = "created_at")
  private LocalDateTime createdAt;
}