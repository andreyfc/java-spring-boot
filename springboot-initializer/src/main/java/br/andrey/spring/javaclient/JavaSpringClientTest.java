package br.andrey.spring.javaclient;

import br.andrey.spring.model.Student;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;


public class JavaSpringClientTest {
    public static void main(String[] args){
        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("http://localhost:8080/v1/protected/student").
                        basicAuthorization("Shima","devdojo").build();
        Student student = restTemplate.getForObject("/{id}", Student.class, 6);
        System.out.println(student);
    }
}
