package com.oeoe.lookcast.service;

import com.oeoe.lookcast.dto.GenerateContentRequest;
import com.oeoe.lookcast.dto.GenerateContentResponse;
import com.oeoe.lookcast.dto.OutfitRequestDTO;
import com.oeoe.lookcast.dto.RecommendationResponse;
import com.oeoe.lookcast.infrastructure.feign.GeminiFeignClient;
import com.oeoe.lookcast.utils.PromptUtils;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GeminiAIRecommendationService implements AIRecommendationService {
  private final GeminiFeignClient geminiFeignClient;

  private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  @Override
  public RecommendationResponse getMessageFromAIAgent(OutfitRequestDTO request) {
    String question = getQuestionBasedUserInfo(request);
    GenerateContentResponse response = geminiFeignClient.generateContent(GenerateContentRequest.createQuestion(question));
    String responseText = response.getCandidates().get(0).getContent().getParts().get(0).getText();
    log.info("Response from Gemini : {}", responseText);
    return RecommendationResponse.of(responseText);
  }

  private String getQuestionBasedUserInfo(OutfitRequestDTO request) {
    if (request == null) {
      return PromptUtils.SYSTEM_INIT_PROMPT + PromptUtils.CLOTHES_CATEGORY + PromptUtils.QUESTION_PROMPT;
    }

    StringBuilder promptBuilder = new StringBuilder();
    promptBuilder.append(PromptUtils.SYSTEM_INIT_PROMPT)
        .append(PromptUtils.CLOTHES_CATEGORY)
        .append(PromptUtils.QUESTION_PROMPT);

    // 사용자 정보 추가
    promptBuilder.append("사용자는 ")
        .append(request.getAge()).append("대 ")
        .append("male".equals(request.getGender()) ? "남성" : "여성").append("이고 ");

    if (request.getStylePreference() != null && !request.getStylePreference().isEmpty()) {
      promptBuilder.append(request.getStylePreference()).append("룩을 즐겨입어. ");
    } else {
      promptBuilder.append("특별한 스타일 선호는 없어. ");
    }

    // 목적 추가
    promptBuilder.append("오늘 ").append(request.getPurpose()).append("을(를) 위해 외출할 예정이야. ");

    // 시간 정보 추가
    promptBuilder.append("지금 시간은 ")
        .append(request.getRequestTime().format(DATE_TIME_FORMATTER))
        .append("이야. ");

    // 현재 위치 및 날씨 추가
    promptBuilder.append("현재 ")
        .append(request.getCurrentLocationName())
        .append("의 온도는 ")
        .append(request.getWeather().getCurrent().getCurrent().getTemp())
        .append("도에 ")
        .append(request.getWeather().getCurrent().getCurrent().getDescription())
        .append("이고 ");

    // 미래 날씨 정보 추가
    promptBuilder.append("3시간 후에는 ")
        .append(request.getWeather().getCurrent().getAfter3h().getTemp())
        .append("도, ")
        .append(request.getWeather().getCurrent().getAfter3h().getDescription())
        .append("으로 예상돼. ");

    // 강수 정보 추가 (관련 있는 경우)
    if (request.getWeather().getCurrent().getAfter3h().getPrecipitation() > 0 ||
        request.getWeather().getCurrent().getAfter6h().getPrecipitation() > 0 ||
        request.getWeather().getCurrent().getAfter9h().getPrecipitation() > 0) {
      promptBuilder.append("오늘 중 비 소식이 있어. ");
    }

    // 목적지 정보 추가 (있는 경우)
    if (request.getDestinationLocationName() != null && !request.getDestinationLocationName().isEmpty()) {
      promptBuilder.append("목적지 ")
          .append(request.getDestinationLocationName())
          .append("의 현재 온도는 ")
          .append(request.getWeather().getDestination().getCurrent().getTemp())
          .append("도에 ")
          .append(request.getWeather().getDestination().getCurrent().getDescription())
          .append("이야. ");
    }

    return promptBuilder.toString();
  }
}
