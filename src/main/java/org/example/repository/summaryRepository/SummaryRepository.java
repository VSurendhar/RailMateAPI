package org.example.repository.summaryRepository;

import org.example.model.entity.Summary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummaryRepository extends JpaRepository<Summary, Integer> {
}
