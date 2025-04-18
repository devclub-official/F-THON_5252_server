package com.oeoe.lookcast.dto;

import lombok.*;

/**
 * 의류 아이템 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClothingItemDTO {
    private Integer id;
    private String code;
    private String categoryName;
    private String name;
    private String imageUrl;
}