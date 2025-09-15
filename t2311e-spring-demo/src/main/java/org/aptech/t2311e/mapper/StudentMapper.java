package org.aptech.t2311e.mapper;

import org.aptech.t2311e.dto.StudentDto;
import org.aptech.t2311e.dto.StudentExamDto;
import org.aptech.t2311e.entity.Student;
import org.aptech.t2311e.entity.StudentExam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {


    public Student dtoToEntity(StudentDto dto){
        Student s = new Student();
        BeanUtils.copyProperties(dto,s);
        return s;
    };
    public  StudentDto entityToDto(Student entity){
        StudentDto dto  = new StudentDto();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }
}
