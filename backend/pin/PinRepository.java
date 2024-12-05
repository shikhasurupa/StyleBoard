package org.example.styleboard.repository;

import org.example.styleboard.model.Pin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PinRepository extends JpaRepository<Pin, Long> {
    List<Pin> findByUserId(Long userId);
}