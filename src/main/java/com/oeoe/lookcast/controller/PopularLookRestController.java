package com.oeoe.lookcast.controller;

import com.oeoe.lookcast.dto.PopularLookResult;
import com.oeoe.lookcast.service.PopularLookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PopularLookRestController {
  private final PopularLookService popularLookService;

  @PostMapping("/popularLook")
  public ResponseEntity<Void> addPopularLook(@RequestBody PopularLookResult request){
    popularLookService.plusPopularLook(request.gender(), request.location(), request.code());
    return ResponseEntity.ok().build();
  }
}
