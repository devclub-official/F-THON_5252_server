package com.oeoe.lookcast.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 의류 카테고리(대분류) DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CategoryDTO {

  private Integer id;
  private String code;        // 카테고리 코드 (ex.TOP, OUTER)
  private String name;        // 카테고리 이름 (ex.상의, 아우터)
  private LocalDateTime createdAt;

  // 카테고리에 속한 의류 아이템 목록
  private List<ClothingItemDTO> items;
}