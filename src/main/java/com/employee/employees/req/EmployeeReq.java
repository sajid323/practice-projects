package com.employee.employees.req;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeReq {
    private long id;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String hireDate;
    private long salary;
}
