package com.oeoe.lookcast.controller;

import com.oeoe.lookcast.dto.OutfitRequestDTO;
import com.oeoe.lookcast.dto.RecommendationResponse;
import com.oeoe.lookcast.service.GeminiAIRecommendationService;
import com.oeoe.lookcast.service.OutfitRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/outfitRequest")
@RequiredArgsConstructor
@Slf4j
public class OutfitRequestController {
  private final OutfitRequestService outfitRequestService;
  private final GeminiAIRecommendationService geminiAIRecommendationService;

  @PostMapping
  public ResponseEntity<RecommendationResponse> createOutfitRequest(@RequestBody OutfitRequestDTO request) {
    // 1. 먼저 요청 저장
    outfitRequestService.saveOutfitRequest(request);

    // 2. AI 추천 요청
    RecommendationResponse recommendation = geminiAIRecommendationService.getMessageFromAIAgent(request);

    // 3. 추천 결과 반환
    return ResponseEntity.ok(recommendation);
  }
}