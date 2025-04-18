package com.oeoe.lookcast.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oeoe.lookcast.dto.ClothingItemDTO;
import com.oeoe.lookcast.entity.ClothingType;

@Repository
public interface ClothingRepository extends JpaRepository<ClothingType, Integer> {

  // 코드로 의류 아이템 조회
  Optional<ClothingType> findByCode(String code);

  // 코드로 의류 아이템 DTO 반환
  @Query("SELECT new com.oeoe.lookcast.dto.ClothingItemDTO(c.id, c.category.id, c.code, c.category.name, c.name, c.imageUrl) " +
      "FROM ClothingType c WHERE c.code = :code")
  ClothingItemDTO findDTOByCode(@Param("code") String code);

  // 카테고리별 의류 아이템 조회
  List<ClothingType> findByCategoryId(Integer categoryId);

  // 카테고리별 의류 아이템 DTO 목록 반환
  @Query("SELECT new com.oeoe.lookcast.dto.ClothingItemDTO(c.id, c.category.id, c.code, c.category.name, c.name, c.imageUrl) " +
      "FROM ClothingType c WHERE c.category.id = :categoryId")
  List<ClothingItemDTO> findDTOsByCategoryId(@Param("categoryId") Integer categoryId);
}