package com.employee.employees.repository;

import com.employee.employees.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employees,Long> {

    @Query("select e from Employees e where e.id =:n" )
    List<Employees> findAllById(@Param("n") Long id);
}
