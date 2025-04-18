package com.oeoe.lookcast.dto;

import lombok.*;
import java.time.LocalDateTime;

/**
 * 사용자가 선택한 코디 정보 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserSelectionDTO {

  private Long id;
  private Long requestId;                  // 연관된 요청 ID
  private String gender;                   // 성별
  private Integer age;                     // 나이
  private String location;                 // 위치
  private String weatherStatus;            // 날씨 상태
  private Double temperature;              // 온도

  // 선택된 의류 정보
  private String topCode;                  // 상의 코드
  private String bottomCode;               // 하의 코드
  private String outerCode;                // 아우터 코드

  private LocalDateTime selectionTime;     // 선택 시간
}
