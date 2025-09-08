package org.aptech.t2311e.repository;

import org.aptech.t2311e.model.StudentExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentExamRepository extends JpaRepository<StudentExam,Long> {
}
