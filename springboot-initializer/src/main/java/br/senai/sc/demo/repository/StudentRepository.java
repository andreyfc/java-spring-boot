package br.senai.sc.demo.repository;

import br.senai.sc.demo.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
