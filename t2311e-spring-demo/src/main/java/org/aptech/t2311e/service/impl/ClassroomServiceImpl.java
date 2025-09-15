package org.aptech.t2311e.service.impl;

import org.aptech.t2311e.dto.ClassRoomSearchDto;
import org.aptech.t2311e.dto.PageDto;
import org.aptech.t2311e.repository.ClassroomRepository;
import org.aptech.t2311e.service.ClassRoomService;
import org.aptech.t2311e.specification.ClassroomSpecification;
import org.aptech.t2311e.specification.StudentExamSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ClassroomServiceImpl implements ClassRoomService {
    @Autowired
    ClassroomRepository classroomRepository;
    @Override
    public PageDto search(ClassRoomSearchDto criteria) {
        Pageable pageable = PageRequest.of(
                criteria.getPageNumber(),  // fixme  : co dk gia tri mac dinh
                criteria.getPageSize(),
                Sort.by("createdAt").descending());
        var page =  classroomRepository.findAll(ClassroomSpecification.filter(criteria),pageable);
        return PageDto
                .builder()
                .data(page.getContent())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .numberOfElements(page.getNumberOfElements())
                .number(page.getNumber())
                .build();
    }
}
