package com.oeoe.lookcast.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clothing_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClothingType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id", nullable = false)
  private Category category;

  @Column(nullable = false, unique = true, length = 30)
  private String code;

  @Column(nullable = false, length = 100)
  private String name;

  @Column(name = "image_url")
  private String imageUrl;

  @Column(name = "created_at")
  private LocalDateTime createdAt;
}