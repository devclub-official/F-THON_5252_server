package com.oeoe.lookcast.service;

import com.oeoe.lookcast.repository.PopularLookRepository;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PopularLookService {
  private final PopularLookRepository popularLookRepository;

  public void plusPopularLook(String gender, String location, List<String> codeSet) {
    String key = getKey(gender, location.replace(" ", ""));
    String normalizedCombination = normalizeLookCombination(codeSet);
    popularLookRepository.incrementLookScore(key, normalizedCombination);
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
