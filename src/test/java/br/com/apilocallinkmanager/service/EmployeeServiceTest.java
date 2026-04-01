package br.com.apilocallinkmanager.service;

import br.com.apilocallinkmanager.domain.EmployeeDomain;
import br.com.apilocallinkmanager.mapper.DomainMapper;
import br.com.apilocallinkmanager.mapper.ModelMapper;
import br.com.apilocallinkmanager.model.Employee;
import br.com.apilocallinkmanager.repository.EmployeeRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.apilocallinkmanager.commom.Fixture.make;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService service;

    @Mock
    private EmployeeRepository repository;

    @Mock
    private DomainMapper domainMapper;

    @Mock
    private ModelMapper modelMapper;

    @Nested
    class WhenCreateEmployee {

        @Test
        void shouldCreateEmployee() {
            final var domain = make(EmployeeDomain.class);
            final var model = make(Employee.class);

            when(modelMapper.map(domain))
                .thenReturn(model);

            when(repository.save(model))
                .thenReturn(model);

            when(domainMapper.map(model))
                .thenReturn(domain);

            final var result = service.createEmployee(domain);

            assertEquals(domain, result);
        }
    }
}
