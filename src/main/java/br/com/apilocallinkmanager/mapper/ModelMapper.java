package br.com.apilocallinkmanager.mapper;

import br.com.apilocallinkmanager.domain.EmployeeDomain;
import br.com.apilocallinkmanager.model.Employee;
import org.mapstruct.Mapper;

@Mapper
public interface ModelMapper {

    Employee map(EmployeeDomain domain);
}
