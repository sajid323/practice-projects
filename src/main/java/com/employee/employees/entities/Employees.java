package com.employee.employees.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employees {

    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String hireDate;
    private long salary;
}
