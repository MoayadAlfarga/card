package com.card.repository;

import com.card.entity.CardStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardStatusRepository extends JpaRepository<CardStatusEntity, Long> {
}
