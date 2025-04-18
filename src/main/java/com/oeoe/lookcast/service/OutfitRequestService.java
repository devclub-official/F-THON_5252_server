package com.oeoe.lookcast.service;

import com.oeoe.lookcast.dto.OutfitRequestDTO;
import com.oeoe.lookcast.entity.OutfitRequest;
import com.oeoe.lookcast.entity.WeatherForecast;
import com.oeoe.lookcast.repository.OutfitRequestRepository;
import com.oeoe.lookcast.repository.WeatherForecastRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OutfitRequestService {

  private final OutfitRequestRepository outfitRequestRepository;
  private final WeatherForecastRepository weatherForecastRepository;

  @Transactional
  public OutfitRequest saveOutfitRequest(OutfitRequestDTO requestDTO) {
    log.info("Saving outfit request: {}", requestDTO);

    // 1. OutfitRequest 엔티티 생성 및 저장
    OutfitRequest outfitRequest = convertToEntity(requestDTO);
    outfitRequest = outfitRequestRepository.save(outfitRequest);

    // 2. 날씨 데이터 저장 (현재 위치)
    saveWeatherForecasts(outfitRequest, requestDTO.getWeather().getCurrent(), false);

    // 3. 날씨 데이터 저장 (목적지)
    saveWeatherForecasts(outfitRequest, requestDTO.getWeather().getDestination(), true);

    return outfitRequest;
  }

  @Transactional
  public List<OutfitRequest> saveOutfitRequests(List<OutfitRequestDTO> requestDTOs) {
    List<OutfitRequest> savedRequests = new ArrayList<>();
    for (OutfitRequestDTO requestDTO : requestDTOs) {
      savedRequests.add(saveOutfitRequest(requestDTO));
    }
    return savedRequests;
  }

  private OutfitRequest convertToEntity(OutfitRequestDTO dto) {
    return OutfitRequest.builder()
        .id(dto.getId())
        .gender(dto.getGender())
        .age(dto.getAge())
        .stylePreference(dto.getStylePreference())
        .purpose(dto.getPurpose())
        .currentLatitude(dto.getCurrentLatitude())
        .currentLongitude(dto.getCurrentLongitude())
        .currentLocationName(dto.getCurrentLocationName())
        .destinationLatitude(dto.getDestinationLatitude())
        .destinationLongitude(dto.getDestinationLongitude())
        .destinationLocationName(dto.getDestinationLocationName())
        .requestTime(dto.getRequestTime())
        .build();
  }

  private void saveWeatherForecasts(OutfitRequest request,
      OutfitRequestDTO.LocationWeather locationWeather,
      boolean isDestination) {
    // 현재 시간 날씨 저장
    saveWeatherPoint(request, locationWeather.getCurrent(), isDestination);

    // 3시간 후 날씨 저장
    saveWeatherPoint(request, locationWeather.getAfter3h(), isDestination);

    // 6시간 후 날씨 저장
    saveWeatherPoint(request, locationWeather.getAfter6h(), isDestination);

    // 9시간 후 날씨 저장
    saveWeatherPoint(request, locationWeather.getAfter9h(), isDestination);
  }

  private void saveWeatherPoint(OutfitRequest request,
      OutfitRequestDTO.WeatherPoint weatherPoint,
      boolean isDestination) {
    WeatherForecast forecast = WeatherForecast.builder()
        .request(request)
        .isDestination(isDestination)
        .forecastTime(weatherPoint.getTime())
        .temperature(weatherPoint.getTemp())
        .weatherStatus(weatherPoint.getDescription())
        .humidity(weatherPoint.getHumidity())
        .precipitation(weatherPoint.getPrecipitation())
        .windSpeed(weatherPoint.getWindSpeed())
        .build();

    weatherForecastRepository.save(forecast);
  }
}