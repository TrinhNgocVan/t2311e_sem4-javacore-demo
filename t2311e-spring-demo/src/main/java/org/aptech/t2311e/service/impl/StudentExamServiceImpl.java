package org.aptech.t2311e.service.impl;

import org.aptech.t2311e.model.StudentExam;
import org.aptech.t2311e.repository.StudentExamRepository;
import org.aptech.t2311e.service.StudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentExamServiceImpl implements StudentExamService {

    @Autowired
    StudentExamRepository studentExamRepository;

    @Override
    public List<StudentExam> getAll() {
        List<StudentExam> studentExams =  studentExamRepository.findAll();
        System.err.println(studentExams);
        return studentExams;
    }

    @Override
    public StudentExam getById(Long id) {
        return null;
    }

    @Override
    public StudentExam add(StudentExam studentExam) {
        return null;
    }

    @Override
    public StudentExam update(StudentExam studentExam) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
