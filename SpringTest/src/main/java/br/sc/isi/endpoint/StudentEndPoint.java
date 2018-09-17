package br.sc.isi.endpoint;

import br.sc.isi.Util.DateUtil;
import br.sc.isi.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("student")
public class StudentEndPoint {
    @Autowired
    private DateUtil dateUtil;
    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<Student> listAll() {
        System.out.println(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return asList(new Student("Deku"),new Student("Todoroki"), new Student("Andrey"));
    }
}