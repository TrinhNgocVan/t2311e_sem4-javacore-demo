package org.aptech.t2311e.mapper;

import org.aptech.t2311e.dto.StudentExamDto;
import org.aptech.t2311e.entity.StudentExam;
import org.springframework.stereotype.Component;

@Component
public class StudentExamMapper {
    public  StudentExam dtoToEntity(StudentExamDto dto){
        return  StudentExam.builder()
                .id(dto.getId())
                .name(dto.getName())
                .createdAt(dto.getCreatedAt())
                .createdBy(dto.getCreatedBy())
                .updatedAt(dto.getUpdatedAt())
                .updatedBy(dto.getUpdatedBy())
                .build();
    };
    public  StudentExamDto entityToDto(StudentExam entity){
        return  StudentExamDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .createdAt(entity.getCreatedAt())
                .createdBy(entity.getCreatedBy())
                .updatedAt(entity.getUpdatedAt())
                .updatedBy(entity.getUpdatedBy())
                .build();
    }

}
