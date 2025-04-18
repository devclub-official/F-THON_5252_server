package com.oeoe.lookcast.infrastructure.feign;

import com.oeoe.lookcast.dto.GenerateContentRequest;
import com.oeoe.lookcast.dto.GenerateContentResponse;
import com.oeoe.lookcast.infrastructure.config.GeminiFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
    name = "geminiFeignClient",
    url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-pro:generateContent",
    configuration = GeminiFeignConfig.class)
public interface GeminiFeignClient {
  @PostMapping
  GenerateContentResponse generateContent(@RequestBody GenerateContentRequest request);
}
