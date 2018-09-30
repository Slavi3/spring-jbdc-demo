package com.telerikacademy.springjbdcdemo.repositories;

import com.telerikacademy.springjbdcdemo.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SqlEmployeeRepository implements EmployeeRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Employee employee) {
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> result = new ArrayList<>();
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            Query query = session.createQuery("from Employee");
            result = query.list();
            session.getTransaction().commit();
        }
        return result;
    }

    @Override
    public Employee getById(int id) {
        Employee result = null;
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            result = session.get(Employee.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public List<Employee> getByJobTitle(String jobTitle) {
        List<Employee> result = new ArrayList<>();
        try (
                Session session = sessionFactory.openSession();
        ) {
            session.beginTransaction();
            Query query = session.createQuery("from Employee where jobTitle=:jobTitle");
            query.setParameter("jobTitle", jobTitle);
            result = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public void update(int id, Employee employee) {
        {
            try (
                    Session session = sessionFactory.openSession();
            ) {
                session.beginTransaction();
                Employee employeeToChange = session.get(Employee.class, id);
                employeeToChange.setFirstName(employee.getFirstName());
                employeeToChange.setLastName(employeeToChange.getLastName());
                employeeToChange.setJobTitle(employeeToChange.getJobTitle());
                session.getTransaction().commit();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void delete(int id) {

    }
}
