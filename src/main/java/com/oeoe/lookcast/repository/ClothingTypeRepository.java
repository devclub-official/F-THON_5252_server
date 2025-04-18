package com.oeoe.lookcast.repository;

import com.oeoe.lookcast.entity.ClothingType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothingTypeRepository extends JpaRepository<ClothingType, Long> {
  Optional<ClothingType> findByCode(String code);
}
