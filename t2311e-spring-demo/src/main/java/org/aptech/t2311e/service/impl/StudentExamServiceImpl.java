package org.aptech.t2311e.service.impl;

import io.micrometer.common.util.StringUtils;
import org.aptech.t2311e.dto.PageDto;
import org.aptech.t2311e.dto.StudentExamDto;
import org.aptech.t2311e.dto.StudentExamSearchDto;
import org.aptech.t2311e.entity.StudentExam;
import org.aptech.t2311e.mapper.StudentExamMapper;
import org.aptech.t2311e.repository.StudentExamRepository;
import org.aptech.t2311e.service.StudentExamService;
import org.aptech.t2311e.specification.StudentExamSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentExamServiceImpl implements StudentExamService {

    @Autowired
    StudentExamRepository studentExamRepository;
    @Autowired
    StudentExamMapper mapper;

    @Override
    public List<StudentExamDto> getAll() {
        // c1
//        List<StudentExam> studentExams =  studentExamRepository.findAll();
//        List<StudentExamDto> studentExamDtos = new ArrayList<>();
//        for (StudentExam exam :  studentExams){
//            studentExamDtos.add(mapper.entityToDto(exam));
//        }
//        return studentExamDtos;
        // c2
//        return studentExamRepository.findAll()
//                .stream()
//                .map(exam -> mapper.entityToDto(exam))
//                .toList();

        return studentExamRepository.findAll()
                .stream()
                .map(mapper::entityToDto)
                .toList();
    }

    @Override
    public Optional<StudentExamDto> getById(Long id) {
        return studentExamRepository.findById(id).map(mapper::entityToDto);
    }

    @Override
    public PageDto search(StudentExamSearchDto criteria) {
        Pageable pageable = PageRequest.of(
                criteria.getPageNumber(),  // fixme  : co dk gia tri mac dinh
                criteria.getPageSize(),
                Sort.by("createdAt").descending());
        var page =  studentExamRepository.findAll(StudentExamSpecification.filter(criteria),pageable);
        return PageDto
                .builder()
                .data(page.getContent())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .numberOfElements(page.getNumberOfElements())
                .number(page.getNumber())
                .build();
    }
//    @Override
//    public StudentExamDto getById(Long id) {
//        return mapper.entityToDto(studentExamRepository.findById(id).get());
//    }

    public static void main(String[] args) {
        /*
        todo  : Optional la 1 container : 1-  chua gia tri kieu T , 2 rong (empty)
         */
        StudentExam exam = new StudentExam();
        String name = exam.getName();
        Optional<String> nameOpt = Optional.ofNullable(exam.getName());
        nameOpt.isEmpty(); // khong co gia tri
        nameOpt.isPresent();// co gia tri

        String name2 ; // logic : neu name not null = name , neu khong "Default Name";
        // c1
        if(StringUtils.isEmpty(name)){
            name2 = "DefaultName";
        }else {
            name2 = name;
        }
        // c2
        name2 = nameOpt.orElse("DefaultName");




    }

    @Override
    public StudentExamDto add(StudentExamDto studentExam) {
        return null;
    }

    @Override
    public StudentExamDto update(StudentExamDto studentExam) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
