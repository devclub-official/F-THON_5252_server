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
@Table(name = "user_selection")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSelection {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 20)
  private String gender;

  @Column(nullable = false, length = 100)
  private String location;

  @Column(name = "top_code", length = 30)
  private String topCode;

  @Column(name = "bottom_code", length = 30)
  private String bottomCode;

  @Column(name = "outer_code", length = 30)
  private String outerCode;

  @Column(name = "selection_time", nullable = false)
  private LocalDateTime selectionTime;
}
