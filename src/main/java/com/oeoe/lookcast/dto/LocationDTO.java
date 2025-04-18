package com.oeoe.lookcast.dto;

import lombok.*;

import java.math.BigDecimal;

/**
 * 위치 정보 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationDTO {
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String locationName;
}