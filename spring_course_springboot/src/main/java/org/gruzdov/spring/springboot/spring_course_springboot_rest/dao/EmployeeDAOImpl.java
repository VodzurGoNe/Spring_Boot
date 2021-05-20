package org.gruzdov.spring.springboot.spring_course_springboot_rest.dao;

import org.gruzdov.spring.springboot.spring_course_springboot_rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public void EntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Session session = entityManager.unwrap(Session.class);
        List<Employee> allEmployees = session.createQuery("from Employee "
                , Employee.class).getResultList();

        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        Session session = entityManager.unwrap(Session.class);

        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(Long id) {
        Session session = entityManager.unwrap(Session.class);

        Query<Employee> query = session.createQuery("delete from Employee " +
                "where id =:employeeId");

        query.setParameter("employeeId", id);
        query.executeUpdate();
    }

}
