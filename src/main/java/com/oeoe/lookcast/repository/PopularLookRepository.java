package com.oeoe.lookcast.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PopularLookRepository {
  private final RedisTemplate<String, String> redisTemplate;

  public void incrementLookScore(String location, String outfitCombination) {
    redisTemplate.opsForZSet().incrementScore(location, outfitCombination, 1.0);
  }

  public List<String> getTopOutfits(String location, long count) {
    Set<String> topOutfits = redisTemplate.opsForZSet().reverseRange(location, 0, count - 1);
    return topOutfits != null ? new ArrayList<>(topOutfits) : new ArrayList<>();
  }
}
