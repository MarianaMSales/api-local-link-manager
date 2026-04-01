package br.com.apilocallinkmanager.service;

import br.com.apilocallinkmanager.domain.EmployeeDomain;
import br.com.apilocallinkmanager.mapper.DomainMapper;
import br.com.apilocallinkmanager.mapper.ModelMapper;
import br.com.apilocallinkmanager.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;
    private final ModelMapper modelMapper;
    private final DomainMapper domainMapper;

    public EmployeeDomain createEmployee(final EmployeeDomain domain) {
        log.info("Creating employee");

        final var model = modelMapper.map(domain);

        return domainMapper.map(
            repository.save(model)
        );
    }
}
