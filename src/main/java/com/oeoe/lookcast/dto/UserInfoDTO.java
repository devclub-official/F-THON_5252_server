package com.oeoe.lookcast.dto;

import lombok.*;

/**
 * 사용자 정보 DTO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserInfoDTO {

  private String gender;          // 성별
  private Integer age;            // 나이
  private String stylePreference; // 선호 스타일
  private String purpose;         // 목적 (데이트, 출근, 여행 등)
}