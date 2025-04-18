package com.oeoe.lookcast.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public record RecommendationResponse(List<String> clothes, String description) {
  private static final ObjectMapper objectMapper = new ObjectMapper();

  public static RecommendationResponse of(String response) {
    try {
      int jsonStart = response.indexOf("{");
      int jsonEnd = response.lastIndexOf("}") + 1;

      if (jsonStart >= 0 && jsonEnd > 0) {
        response = response.substring(jsonStart, jsonEnd);
      }

      return objectMapper.readValue(response, RecommendationResponse.class);
    } catch (Exception e) {
      List<String> defaultClothes = List.of( //TODO :: 캐시에서 가져온 정보
          "캐주얼 셔츠, 청바지, 스니커즈",
          "맨투맨, 면바지, 운동화",
          "티셔츠, 가디건, 슬랙스, 로퍼"
      );
      return new RecommendationResponse(defaultClothes, "현재 위치에서 가장 많은 코디 조합이예요");
    }
  }
}
