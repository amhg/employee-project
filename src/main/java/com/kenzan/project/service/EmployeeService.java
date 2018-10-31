package com.kenzan.project.service;

import com.kenzan.project.model.Employee;
import com.kenzan.project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAllEmployees(){
        return (List<Employee>) employeeRepository.findAll();
    }

    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee ) {
        return employeeRepository.save( employee );
    }

    public void deleteEmployee(Employee employee){
        employeeRepository.delete(employee);
    }

    public Optional<Employee> findByLastName(String lastName )
    {

        return employeeRepository.findByLastName( lastName );
    }

    public Optional<Employee> findByDateOfBirth(Date dateOfBirth )
    {
        return employeeRepository.findByDateOfBirth( dateOfBirth );
    }


}
