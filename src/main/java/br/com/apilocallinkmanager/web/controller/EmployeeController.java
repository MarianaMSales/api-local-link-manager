package br.com.apilocallinkmanager.web.controller;

import br.com.apilocallinkmanager.mapper.DomainMapper;
import br.com.apilocallinkmanager.service.EmployeeService;
import br.com.apilocallinkmanager.web.controller.dto.request.CreateEmployeeRequest;
import br.com.apilocallinkmanager.web.controller.dto.response.CreateEmployeeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;
    private final DomainMapper domainMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateEmployeeResponse create(@RequestBody @Valid final CreateEmployeeRequest request) {
        final var domain = domainMapper.map(request);

        return new CreateEmployeeResponse(
            service.createEmployee(domain).id()
        );
    }
}
