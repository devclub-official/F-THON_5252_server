package com.oeoe.lookcast.service;

import com.oeoe.lookcast.dto.OutfitRequestDTO;
import com.oeoe.lookcast.dto.RecommendationResponse;

public interface AIRecommendationService {
  RecommendationResponse getMessageFromAIAgent(OutfitRequestDTO request);

}