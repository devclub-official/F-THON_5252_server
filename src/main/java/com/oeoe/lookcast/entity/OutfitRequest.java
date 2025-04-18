package com.oeoe.lookcast.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "outfit_request")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OutfitRequest {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  private LocalDateTime requestTime;
}