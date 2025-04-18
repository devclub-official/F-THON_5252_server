package com.oeoe.lookcast.repository;

import com.oeoe.lookcast.entity.WeatherForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherForecastRepository extends JpaRepository<WeatherForecast, Long> {

}