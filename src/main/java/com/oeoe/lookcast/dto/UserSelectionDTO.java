package com.oeoe.lookcast.dto;

import lombok.*;

/**
 * 사용자 코디 선택 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSelectionDTO {
    private Long requestId;
    private Integer selectedOutfitNumber;
}