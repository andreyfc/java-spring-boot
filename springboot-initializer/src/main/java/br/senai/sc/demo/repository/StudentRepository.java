package br.senai.sc.demo.repository;

import br.senai.sc.demo.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

    List<Student> findByNameIgnoreCaseContaining(String name);

    void deleteById(Long id);
}
