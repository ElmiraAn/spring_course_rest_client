package com.elmiraantipina.spring.rest;

import com.elmiraantipina.spring.rest.configuration.MyConfig;
import com.elmiraantipina.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);//создаем бин Communication
        //List<Employee> allEmployee = communication.getAllEmployees();
        //System.out.println(allEmployee);

        //Employee empByID = communication.getEmployee(1);
        //System.out.println(empByID);

        //Employee emp = new Employee("Sveta","Sokolova","IT", 1200);
        //emp.setId(12);
        //communication.saveEmployee(emp);

        //communication.deleteEmployee(12);

        context.close();
    }
}
