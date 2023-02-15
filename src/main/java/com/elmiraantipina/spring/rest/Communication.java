package com.elmiraantipina.spring.rest;

import com.elmiraantipina.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {
    //с помощью объекта этого класса и его методов, мы будем общаться с REST Service,
    // то есть осуществлять HTTP-заросы и получать ответы
    @Autowired
    private RestTemplate restTemplate;

    private final String URL = "http://localhost:8080/spring_course_rest/api/employees";

    public List<Employee> getAllEmployees() {
        //Ответ на наш запрос:
        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null
                        , new ParameterizedTypeReference<List<Employee>>() {});
        //ResponseEntity - это обертка HTTP-response
        //<List<Employee>> - тип тела response
        //URL - по какому адресу проиисходит запрос, второй параметр - по какому методу,
        // 3-й - тело запроса, у get оно всегда пустое,
        //ParameterizedTypeReference<List<Employee>> - вспосогат класс, цель которого передача дженерик типа, то есть список работнкиов
        List<Employee> allEmployees = responseEntity.getBody();//получаем PayLoad, полезную нагрузку
        return allEmployees;
    }

    public Employee getEmployee(int id) {
        Employee employee = restTemplate.getForObject(URL+"/"+id, Employee.class);

        return employee;
    }

    public void saveEmployee(Employee employee) {

        int id = employee.getId();
        if (id==0){
            ResponseEntity<String> responseEntity =
                    restTemplate.postForEntity(URL, employee, String.class);//добавление работника
            System.out.println("New employee was added to DataBase");
            System.out.println(responseEntity.getBody());
        }else {
            restTemplate.put(URL, employee);//изменение работника
            System.out.println("Employee with ID = "+id+" was updated");
        }


    }

    public void deleteEmployee(int id) {
        restTemplate.delete(URL+"/"+id);
        System.out.println("Employee with ID = "+id+" was deleted from Database");
    }
}
