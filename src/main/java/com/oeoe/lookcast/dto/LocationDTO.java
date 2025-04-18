package com.oeoe.lookcast.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 위치 정보 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LocationDTO {

  private Double latitude;     // 위도
  private Double longitude;    // 경도
  private String locationName; // 위치명
}