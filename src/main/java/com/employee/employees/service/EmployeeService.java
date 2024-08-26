package com.employee.employees.service;

import com.employee.employees.entities.Employees;
import com.employee.employees.repository.EmployeeRepository;
import com.employee.employees.req.EmployeeReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    public List<Employees> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public List<Employees> getEmployeeById(Long id) {
        return employeeRepository.findAllById(id);
    }

    public Employees saveEmployee(Employees newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    public List<Employees> findByEmployeeId(EmployeeReq employeeReq) {
        return employeeRepository.findAllById(employeeReq.getId());
    }

    public Optional<Employees> findById(long id) {
        return employeeRepository.findById(id);
    }

    public void deleteByEmployeeId(long id) {
       employeeRepository.deleteById(id);
    }
}
