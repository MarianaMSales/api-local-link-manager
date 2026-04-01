package br.com.apilocallinkmanager.web.controller;

import br.com.apilocallinkmanager.domain.EmployeeDomain;
import br.com.apilocallinkmanager.mapper.DomainMapper;
import br.com.apilocallinkmanager.service.EmployeeService;
import br.com.apilocallinkmanager.web.controller.dto.request.CreateEmployeeRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static br.com.apilocallinkmanager.commom.Fixture.make;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    private static final String URL = "/v1/employees";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService service;

    @MockBean
    private DomainMapper domainMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Nested
    class WhenCreate {

        @Test
        @SneakyThrows
        void shouldReturnCreated() {
            final var request = make(CreateEmployeeRequest.class);
            final var domain = make(EmployeeDomain.class);

            when(domainMapper.map(request))
                .thenReturn(domain);

            when(service.createEmployee(domain))
                .thenReturn(domain);

            mockMvc.perform(post(URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(domain.id().toString()));
        }
    }
}
