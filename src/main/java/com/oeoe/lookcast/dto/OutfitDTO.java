package com.oeoe.lookcast.dto;

import lombok.*;

/**
 * 코디 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutfitDTO {
    private Integer outfitNumber;
    private ClothingItemDTO top;
    private ClothingItemDTO bottom;
    private ClothingItemDTO outer;
    private ClothingItemDTO accessory;
}