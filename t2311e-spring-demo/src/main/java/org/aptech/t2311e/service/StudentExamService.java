package org.aptech.t2311e.service;


import org.aptech.t2311e.dto.StudentExamDto;
import org.aptech.t2311e.dto.StudentExamSearchDto;
import org.aptech.t2311e.entity.StudentExam;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentExamService {
    List<StudentExamDto> getAll();
    Optional<StudentExamDto> getById(Long id);
//    StudentExamDto getById(Long id);
    List<StudentExamDto> search(StudentExamSearchDto criteria);
    StudentExamDto add(StudentExamDto studentExam);
    StudentExamDto update(StudentExamDto studentExam);
    Boolean delete(Long id);
}
