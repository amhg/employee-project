package com.kenzan.project.repository;

import com.kenzan.project.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    Optional<Employee> findByLastName(String lastName);
    Optional<Employee> findByDateOfBirth(Date dateOfBirth);
}
