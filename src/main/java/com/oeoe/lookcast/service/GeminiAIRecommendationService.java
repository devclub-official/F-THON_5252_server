package com.oeoe.lookcast.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeminiAIRecommendationService implements AIRecommendationService {

  @Override
  public String getMessageFromAIAgent() {
    return "";
  }

}
