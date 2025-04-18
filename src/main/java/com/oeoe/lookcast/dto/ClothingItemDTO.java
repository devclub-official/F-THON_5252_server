package com.oeoe.lookcast.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 의류 아이템 DTO 각 카테고리에 속한 개별 의류 유형 정보
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ClothingItemDTO {

  private Integer id;
  private Integer categoryId;   // 상위 카테고리 ID
  private String code;          // 의류 아이템 코드 (ex.TOP_TSHIRT_SHORT)
  private String categoryName;  // 카테고리 이름
  private String name;          // 의류 이름 (ex.반팔 티셔츠)
  private String imageUrl;      // 이미지 URL
}