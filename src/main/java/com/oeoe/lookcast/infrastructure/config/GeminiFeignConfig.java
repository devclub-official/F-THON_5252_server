package com.oeoe.lookcast.infrastructure.config;

import com.oeoe.lookcast.infrastructure.properties.GeminiProperties;
import feign.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
@EnableConfigurationProperties(GeminiProperties.class)
public class GeminiFeignConfig {
  private final GeminiProperties geminiProperties;

  @Bean
  public RequestInterceptor requestInterceptor() {
    return requestTemplate -> {
      requestTemplate.header("Content-Type", "application/json; charset=utf-8");
      requestTemplate.header("x-goog-api-key", geminiProperties.getApiKey());
    };
  }
}
