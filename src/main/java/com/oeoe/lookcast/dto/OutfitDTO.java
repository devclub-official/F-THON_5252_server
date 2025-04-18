package com.oeoe.lookcast.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 코디 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OutfitDTO {

  private Long id;                  // 코디 ID
  private Integer outfitNumber;     // 코디 번호
  private ClothingItemDTO top;      // 상의
  private ClothingItemDTO bottom;   // 하의
  private ClothingItemDTO outer;    // 아우터
  private ClothingItemDTO shoes;    // 신발
  private ClothingItemDTO accessory; // 액세서리
  private String description;       // 코디 설명

}