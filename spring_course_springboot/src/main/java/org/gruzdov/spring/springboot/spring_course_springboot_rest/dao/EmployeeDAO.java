package org.gruzdov.spring.springboot.spring_course_springboot_rest.dao;


import org.gruzdov.spring.springboot.spring_course_springboot_rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(Long id);

    void deleteEmployee(Long id);
}
