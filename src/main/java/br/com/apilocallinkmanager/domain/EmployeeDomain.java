package br.com.apilocallinkmanager.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record EmployeeDomain(
    UUID id,
    String name,
    String email,
    String password,
    String phone,
    String city,
    String state,
    String education,
    String bio,
    BigDecimal rating,
    Integer totalReviews,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
}
