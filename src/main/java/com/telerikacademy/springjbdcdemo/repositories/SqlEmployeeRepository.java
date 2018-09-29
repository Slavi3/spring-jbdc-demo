package com.telerikacademy.springjbdcdemo.repositories;

import java.sql.*;

import com.telerikacademy.springjbdcdemo.models.Employee;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
@PropertySource("classpath:application.properties")
public class SqlEmployeeRepository implements EmployeeRepository {
    private String dbUrl, username, password;
    List<Employee>employees=new ArrayList<>();

    public SqlEmployeeRepository(Environment env) {
        dbUrl=env.getProperty("database.url");
        username=env.getProperty("database.username");
        password=env.getProperty("database.password");
    }

    @Override
    public void create(Employee employee) {

    }

    @Override
    public List<Employee> getAll() {
        String query="select employeeId,firstName,lastName,title from  employees ";
        try (
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
        ){
            employees=readData(resultSet);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public Employee getById(int id) {
        return null;
    }

    @Override
    public List<Employee> getByJobTitle(String jobTitle) {

        String query="select employeeId,firstName,lastName,title " +
                "from  employees " +
                "where title=?";
        try {
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            PreparedStatement statement=connection.prepareStatement(query);
            statement.setString(1,jobTitle);
            ResultSet resultSet=statement.executeQuery();
            employees=readData(resultSet);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public void update(int id, Employee employee) {

    }

    @Override
    public void delete(int id) {

    }
    private List<Employee> readData(ResultSet employeesData)throws  SQLException{
        List<Employee> employees=new ArrayList<>();
        while(employeesData.next()){
            Employee e=new Employee(
                    employeesData.getInt("EmployeeID"),
                    employeesData.getString("FirstName"),
                    employeesData.getString("LastName"),
                    employeesData.getString("Title")

            );
            employees.add(e);

        }
        return  employees;
    }
}
