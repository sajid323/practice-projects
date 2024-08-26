package com.employee.employees.controllers;

import com.employee.employees.entities.Employees;
import com.employee.employees.req.EmployeeReq;
import com.employee.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employees>> getAllEmployee() {
        List<Employees> employees = employeeService.getAllEmployee();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<List<Employees>> getEmployeeById(@PathVariable Long id) {
        List<Employees> employees = employeeService.getEmployeeById(id);
        if (id != null) {
            return ResponseEntity.ok(employees);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
    }

    @PostMapping("/employee/new")
    public List<Employees> newEmployee(@RequestBody EmployeeReq employeeReq) {
        Employees newEmployee = new Employees();
        newEmployee.setId(employeeReq.getId());
        newEmployee.setFirstName(employeeReq.getFirstName());
        newEmployee.setLastName(employeeReq.getLastName());
        newEmployee.setJobTitle(employeeReq.getJobTitle());
        newEmployee.setHireDate(employeeReq.getHireDate());
        newEmployee.setSalary(employeeReq.getSalary());

        Employees savedEmployee = employeeService.saveEmployee(newEmployee);
        return Collections.singletonList(savedEmployee);
    }

    @PutMapping("/employee/update/{id}")
    public List<Employees> updateEmployee(@RequestBody EmployeeReq employeeReq, @PathVariable long id) {
        Optional<Employees> updateEmployee = employeeService.findById(id);
        if (updateEmployee.isPresent()) {
            Employees employee = updateEmployee.get();
            employee.setFirstName(employeeReq.getFirstName());
            employee.setLastName(employeeReq.getLastName());
            employee.setJobTitle(employeeReq.getJobTitle());
            employee.setHireDate(employeeReq.getHireDate());
            employee.setSalary(employeeReq.getSalary());
            Employees updatedEmployee = employeeService.saveEmployee(employee);

        return Collections.singletonList(updatedEmployee);
    }else
        return null;

    }
    @DeleteMapping("/employee/delete/{id}")
    public Employees deleteEmployee(@PathVariable long id){
        Optional<Employees> deleteEmployee = employeeService.findById(id);
        if(deleteEmployee.isPresent()){
            employeeService.deleteByEmployeeId(id);
        }
        return null;
    }
}
