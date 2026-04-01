package br.com.apilocallinkmanager.web.controller.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateEmployeeRequest(

    @NotBlank String name,
    @NotBlank String email,
    @NotBlank String password,
    @NotBlank String phone,
    @NotBlank String city,
    @NotBlank String state,
    @NotBlank String education,
    String bio
) {
}
