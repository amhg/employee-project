package com.kenzan.project.controller;

import com.kenzan.project.model.Employee;
import com.kenzan.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employee/{id}")
    private ResponseEntity<?> getEmployee(@PathVariable Long id){
        Optional<Employee> e = employeeService.findEmployeeById(id);

        if(!e.isPresent()){
            return new ResponseEntity<>("Employee not registered" ,HttpStatus.BAD_REQUEST);
        }

        Employee employee = e.get();

        if(employee.getStatus().equals("INACTIVE")){
            return new ResponseEntity<>("Empoyee is Inactive", HttpStatus.OK);

        }

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping(value = "/employee")
    private ResponseEntity<?> getAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployees();

        if(employees.isEmpty()){
            return new ResponseEntity<>("No Employees Found", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping(value = "/employee")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee){

        if(  employeeService.findByDateOfBirth(employee.getDateOfBirth()).isPresent()){
            return new ResponseEntity<>("There is already an employee registered", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }


    @PutMapping("/update/employee/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee, @PathVariable(value = "id") Long id){
        Optional<Employee> optionalEmployee = employeeService.findEmployeeById(id);

        if(!optionalEmployee.isPresent())
            return new ResponseEntity<>("Employee not registered" ,HttpStatus.BAD_REQUEST);

        employee.setId(id);

        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/delete/employee/{id}")
    private ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Long id ){
        Optional<Employee> e = employeeService.findEmployeeById(id);

        if(!e.isPresent()){
            return new ResponseEntity<>("Employee does not exist" ,HttpStatus.BAD_REQUEST);
        }

        Employee employee = e.get();
        employee.setId(id);
        employee.setStatus("INACTIVE");
        employeeService.saveEmployee(employee);

        //employeeService.deleteEmployee(employee);

        return new ResponseEntity<>("Employee Inactive", HttpStatus.OK);

    }
}
