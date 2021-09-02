package com.gabrielpeixoto.studentapi.repository;

import com.gabrielpeixoto.studentapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
