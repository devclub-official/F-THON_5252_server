package com.oeoe.lookcast.service;

import com.oeoe.lookcast.entity.UserSelection;
import com.oeoe.lookcast.repository.PopularLookRepository;
import com.oeoe.lookcast.repository.UserSelectionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PopularLookService {
  private final PopularLookRepository popularLookRepository;
  private final UserSelectionRepository userSelectionRepository;

  @Transactional
  public void plusPopularLook(String gender, String location, List<String> codeSet) {
    String key = getKey(gender, location.replace(" ", ""));
    String normalizedCombination = normalizeLookCombination(codeSet);
    popularLookRepository.incrementLookScore(key, normalizedCombination);

    // UserSelection 저장
    try {
      // 카테고리별 코드 분류
      String topCode = null;
      String bottomCode = null;
      String outerCode = null;

      // 각 코드를 접두어로 분류
      for (String code : codeSet) {
        if (code == null || code.isEmpty()) {
          continue;
        }

        if (code.startsWith("TOP_")) {
          topCode = code;
        } else if (code.startsWith("BOTTOM_")) {
          bottomCode = code;
        } else if (code.startsWith("OUTER_")) {
          outerCode = code;
        }
      }

      // UserSelection 저장
      UserSelection userSelection = UserSelection.builder()
          .gender(gender)
          .location(location)
          .topCode(topCode)
          .bottomCode(bottomCode)
          .outerCode(outerCode)
          .selectionTime(LocalDateTime.now())
          .build();

      userSelectionRepository.save(userSelection);
      log.info("인기 룩 데이터가 UserSelection에 저장됨: {}", userSelection);
    } catch (Exception e) {
      log.error("UserSelection 저장 중 오류 발생: {}", e.getMessage());
    }
  }

  private String getKey(String gender, String location) {
    return String.join("-", gender, location);
  }

  private String normalizeLookCombination(List<String> codeSet) {
    Collections.sort(codeSet);
    return String.join(", ", codeSet);
  }

  public List<String> getPopularLookListByPlace(String gender, String location) {
    String key = getKey(gender, location);
    return popularLookRepository.getTopOutfits(key, 5);
  }
}