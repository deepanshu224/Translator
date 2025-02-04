package com.example.bharatfd.repository;

import com.example.bharatfd.models.FAQ;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FAQRepository extends JpaRepository<FAQ, Integer> {
    List<FAQ> findByLanguage(String language);
}
