package com.example.bookbti.repository;

import com.example.bookbti.entity.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestResultRepository extends JpaRepository<TestResult, String> {
}
