package br.andrey.spring.repository;

import br.andrey.spring.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

    List<Student> findByNameIgnoreCaseContaining(String name);

    void deleteById(Long id);
}
