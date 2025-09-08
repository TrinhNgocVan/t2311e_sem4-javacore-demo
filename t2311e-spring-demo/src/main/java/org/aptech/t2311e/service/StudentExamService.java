package org.aptech.t2311e.service;


import org.aptech.t2311e.model.StudentExam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentExamService {
    List<StudentExam> getAll();
    StudentExam getById(Long id);
    StudentExam add(StudentExam studentExam);
    StudentExam update(StudentExam studentExam);
    Boolean delete(Long id);
}
