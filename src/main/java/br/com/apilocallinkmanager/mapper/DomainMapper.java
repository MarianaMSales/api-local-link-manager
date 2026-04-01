package br.com.apilocallinkmanager.mapper;

import br.com.apilocallinkmanager.domain.EmployeeDomain;
import br.com.apilocallinkmanager.model.Employee;
import br.com.apilocallinkmanager.web.controller.dto.request.CreateEmployeeRequest;
import org.mapstruct.Mapper;

@Mapper
public interface DomainMapper {

    EmployeeDomain map(Employee model);

    EmployeeDomain map(CreateEmployeeRequest request);
}
