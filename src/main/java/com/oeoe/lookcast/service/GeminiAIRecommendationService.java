package com.oeoe.lookcast.service;

import com.oeoe.lookcast.dto.GenerateContentRequest;
import com.oeoe.lookcast.dto.GenerateContentResponse;
import com.oeoe.lookcast.dto.RecommendationResponse;
import com.oeoe.lookcast.infrastructure.feign.GeminiFeignClient;
import com.oeoe.lookcast.utils.PromptUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GeminiAIRecommendationService implements AIRecommendationService {
  private final GeminiFeignClient geminiFeignClient;

  @Override
  public RecommendationResponse getMessageFromAIAgent() {
    String question = getQuestionBasedUserInfo(); // TODO :: userInfo, weatherInfo, ScheduleInfo
    GenerateContentResponse response = geminiFeignClient.generateContent(GenerateContentRequest.createQuestion(question));
    String responseText = response.getCandidates().get(0).getContent().getParts().get(0).getText();
    log.info("Response from Gemini : {}", responseText);
    return RecommendationResponse.of(responseText);
  }

  private String getQuestionBasedUserInfo() {
    return PromptUtils.SYSTEM_INIT_PROMPT + PromptUtils.CLOTHES_CATEGORY + PromptUtils.QUESTION_PROMPT
        +  "사용자는 20대 초반 여성이고 캐주얼룩을 즐겨입어. 오늘 오전에 학교를 갔다가 오후에 알바를 하러갈거야 지금 시간은 4월 19일 오전 7시 30분이야 현재 경기도 부천시의 온도는 7도에 맑음이고 오후 3시부터 비가 올 예정이야";
  }
}
