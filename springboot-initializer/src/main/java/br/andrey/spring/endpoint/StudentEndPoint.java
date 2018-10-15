package br.andrey.spring.endpoint;

import br.andrey.spring.endpoint.error.ResourceNotFoundException;
import br.andrey.spring.model.Student;
import br.andrey.spring.repository.StudentRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("v1")
public class StudentEndPoint {

    public StudentEndPoint(StudentRepository studentDAO){this.studentDAO = studentDAO;}
    @Autowired
    private StudentRepository studentDAO;

    @GetMapping(path = "protected/student")
    @ApiOperation(value = "Return a list with all students", response = Student[].class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Bearer token",
            required = true, dataType = "string", paramType = "header")
    })
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(studentDAO.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "protected/student/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id, Authentication authentication) {
        System.out.println(authentication);
        verifyStudentExists(id);
        Student student = studentDAO.findById(id).get();
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping(path = "protected/student/findByName/{name}")
    public ResponseEntity<?> findStudentsByName(@PathVariable String name) {
        return new ResponseEntity<>(studentDAO.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
    }

    @PostMapping(path = "admin/student")
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<?> save(@Valid @RequestBody Student student) {
        return new ResponseEntity<>(studentDAO.save(student), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "admin/student/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        verifyStudentExists(id);
        studentDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "admin/student")
    public ResponseEntity<?> update(@RequestBody Student student) {
        verifyStudentExists(student.getId());
        studentDAO.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyStudentExists(Long id) {
        Optional<Student> studentOptional = studentDAO.findById(id);

        if (!studentOptional.isPresent())
            throw new ResourceNotFoundException("student not found fo ID: " + id);
    }

}