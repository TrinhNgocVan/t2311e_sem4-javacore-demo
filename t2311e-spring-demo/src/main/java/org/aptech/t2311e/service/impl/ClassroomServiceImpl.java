package org.aptech.t2311e.service.impl;

import jakarta.transaction.Transactional;
import org.aptech.t2311e.controller.ClassRoomController;
import org.aptech.t2311e.dto.ClassRoomDto;
import org.aptech.t2311e.dto.ClassRoomSearchDto;
import org.aptech.t2311e.dto.PageDto;
import org.aptech.t2311e.mapper.ClassroomMapper;
import org.aptech.t2311e.repository.ClassroomRepository;
import org.aptech.t2311e.repository.StudentRepository;
import org.aptech.t2311e.service.ClassRoomService;
import org.aptech.t2311e.specification.ClassroomSpecification;
import org.aptech.t2311e.specification.StudentExamSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
public class ClassroomServiceImpl implements ClassRoomService {

    private static final Logger logger = LoggerFactory.getLogger(ClassroomServiceImpl.class);

    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClassroomMapper mapper;

    @Override
    @Transactional
    public boolean insert(ClassRoomDto classRoom) {
        // trung ten, trung ma lop , bat dau o tuong lai qua 1 nam, ket thuc o qua khu
        if(validateInsert(classRoom)){
            classroomRepository.saveAndFlush(mapper.dtoToEntity(classRoom));
        }
        return true;
    }

    boolean validateInsert(ClassRoomDto classRoom){
        if(!classroomRepository.existsByNameOrCode(classRoom.getName(), classRoom.getCode())){
            logger.error("Name or Code is exited, name : {} , code : {}", classRoom.getName(), classRoom.getCode());
            return false;
        }
        if(classRoom.getEndTime().isBefore(LocalDate.now())){
            logger.error("Endtime cannot before now, endTime  = {}", classRoom.getEndTime());
            return false;
        }

        if(classRoom.getStartTime().isAfter(LocalDate.now().plusYears(1))){
            logger.error("Startime cannot one year later from now, startTime  = {}", classRoom.getStartTime());
            return false;
        }
        return true;
    }

    @Override
    public PageDto search(ClassRoomSearchDto criteria) {
        Pageable pageable = PageRequest.of(
                criteria.getPageNumber(),  // fixme  : co dk gia tri mac dinh
                criteria.getPageSize(),
                Sort.by("startTime").descending());
        var page =  classroomRepository.findAll(ClassroomSpecification.filter(criteria),pageable);

        var classRoomDtos =  page.getContent().
                stream()
                .map(mapper::entityToDto)
                .toList();
        classRoomDtos.forEach( c
                -> c.setNumberOfStudents(studentRepository.countByclassRoom_Id(c.getId())));

//        // c1 :set classroom.totalStudents in classRoomDtos
//        classRoomDtos.forEach(c -> c.setNumberOfStudents(c.getStudents().size()));

        // xu ly  bussiness -> luon luon su dung DTO
        return PageDto
                .builder()
                .data(classRoomDtos)
//                .data(page.getContent().stream().map(entity -> mapper.entityToDto(entity)).toList())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .numberOfElements(page.getNumberOfElements())
                .number(page.getNumber())
                .build();
    }




}
