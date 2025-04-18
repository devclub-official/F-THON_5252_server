package com.oeoe.lookcast.controller;

import com.oeoe.lookcast.dto.PopularLookResult;
import com.oeoe.lookcast.service.PopularLookService;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/popularLook")
@RequiredArgsConstructor
@Validated
public class PopularLookRestController {
  private final PopularLookService popularLookService;

  @PostMapping
  public ResponseEntity<Void> addPopularLook(@RequestBody PopularLookResult request) {
    popularLookService.plusPopularLook(request.gender(), request.location(), request.code());
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<List<String>> getPopularLook(
      @RequestParam("gender") @NotBlank String gender, @RequestParam("location") @NotBlank String location) {
    return ResponseEntity.ok(popularLookService.getPopularLookListByPlace(gender, location));
  }
}
