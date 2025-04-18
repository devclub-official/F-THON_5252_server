package com.oeoe.lookcast.repository;

import com.oeoe.lookcast.entity.OutfitRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutfitRequestRepository extends JpaRepository<OutfitRequest, Long> {

}