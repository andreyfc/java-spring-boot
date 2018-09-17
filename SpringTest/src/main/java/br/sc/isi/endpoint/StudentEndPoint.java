package br.sc.isi.endpoint;

import br.sc.isi.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("student")
public class StudentEndPoint {
    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<Student> listAll() {
        return asList(new Student("Deku"),new Student("Todoroki"), new Student("Andrey"));
    }
}

git remote set-url origin https:https://github.com/andreyfc/java-spring-boot.git