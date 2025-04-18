package com.oeoe.lookcast.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "outfit_request")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutfitRequest {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 20)
  private String gender;

  @Column(nullable = false)
  private Integer age;

  @Column(name = "style_preference", length = 50)
  private String stylePreference;

  @Column(length = 50)
  private String purpose;

  @Column(name = "current_latitude")
  private Double currentLatitude;

  @Column(name = "current_longitude")
  private Double currentLongitude;

  @Column(name = "current_location_name", length = 100)
  private String currentLocationName;

  @Column(name = "destination_latitude")
  private Double destinationLatitude;

  @Column(name = "destination_longitude")
  private Double destinationLongitude;

  @Column(name = "destination_location_name", length = 100)
  private String destinationLocationName;

  @Column(name = "request_time", nullable = false)
  private LocalDateTime requestTime;

  @OneToMany(mappedBy = "request")
  private List<WeatherForecast> weatherForecasts = new ArrayList<>();

  @OneToMany(mappedBy = "request")
  private List<UserSelection> userSelections = new ArrayList<>();
}