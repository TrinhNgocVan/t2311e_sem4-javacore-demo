package org.aptech.t2311e.service.impl;

import lombok.SneakyThrows;
import org.aptech.t2311e.dto.ClassRoomDto;
import org.aptech.t2311e.dto.ClassRoomSearchDto;
import org.aptech.t2311e.dto.PageDto;
import org.aptech.t2311e.entity.ClassRoom;
import org.aptech.t2311e.entity.TransactionHistory;
import org.aptech.t2311e.entity.constants.ActionType;
import org.aptech.t2311e.exception.BussinessException;
import org.aptech.t2311e.mapper.ClassroomMapper;
import org.aptech.t2311e.repository.ClassroomRepository;
import org.aptech.t2311e.repository.StudentRepository;
import org.aptech.t2311e.repository.TransactionHistoryRepository;
import org.aptech.t2311e.service.ClassRoomService;
import org.aptech.t2311e.specification.ClassroomSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class ClassroomServiceImpl implements ClassRoomService {

    private static final Logger logger = LoggerFactory.getLogger(ClassroomServiceImpl.class);

    // bean singleton
    List<TransactionHistory> transactionHistoryList = new ArrayList<>();


    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TransactionHistoryRepository transactionHistoryRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ClassroomMapper mapper;

    @Override
    public boolean insert(ClassRoomDto classRoom) throws BussinessException {
        var startTime = LocalDateTime.now();
        // trung ten, trung ma lop , bat dau o tuong lai qua 1 nam, ket thuc o qua khu
        // todo  -> bo sung luong luu transaction_history
        checkDuplicateNameOrCode(classRoom);
        validateTime(classRoom);
//       transactionHistoryList.add(new TransactionHistory("admin",
//                ActionType.SAVE_CLASSROOM.name(),startTime)); // 1 - ok
        classroomRepository.save(mapper.dtoToEntity(classRoom)); // 2 - failed
        return true;
    }

    @SneakyThrows
    @Override
    @Transactional
    public boolean insert(List<ClassRoomDto> classRooms) throws BussinessException {
       /*
       TPS : Transaction per seconds
       CCU : Concurrent Users (Nguoi dung dong thoi)
        */
        validateListInsert(classRooms);
        batchInsert(classRooms.stream().map(mapper::dtoToEntity).toList());
        return true;
    }

    public void batchInsert(List<ClassRoom> classRooms){
        String sql = "INSERT into class_room (name,code,description, current_semester, start_time,end_time)" +
                "values(?,?,?,?,?,?)";
        jdbcTemplate.batchUpdate(sql, classRooms
        ,1000, // batch size
        (ps, c) -> {
           ps.setString(1, c.getName());
           ps.setString(2, c.getCode());
           ps.setString(3, c.getDescription());
           ps.setInt(4, c.getCurrentSemester());
           ps.setDate(5, null); // todo : recheck
           ps.setDate(6, null);
        });
    }

    private void validateListInsert(List<ClassRoomDto> classRooms) throws BussinessException {
        List<String> names  = classRooms.stream().map(ClassRoomDto::getName).toList();
        List<String> codes  = classRooms.stream().map(ClassRoomDto::getCode).toList();
        if(!CollectionUtils.isEmpty(classroomRepository.findByNamesOrCodes(names, codes))){
            logger.error("Names or Codes has item is exited, names : {} , codes : {}", names, codes);
            throw new BussinessException("Name or Code is exited", "1001", HttpStatus.OK);
        }
        for (ClassRoomDto c : classRooms){
            validateTime(c);
        }
    }

    private void checkDuplicateNameOrCode(ClassRoomDto classRoom) throws BussinessException {
        if(classroomRepository.existsByNameOrCode(classRoom.getName(), classRoom.getCode())){
            logger.error("Name or Code is exited, name : {} , code : {}", classRoom.getName(), classRoom.getCode());
            throw new BussinessException("Name or Code is exited", "1001", HttpStatus.OK);
        }
    }


    private void validateTime(ClassRoomDto classRoom) throws BussinessException {
        if(Objects.nonNull(classRoom.getEndTime())
            && classRoom.getEndTime().isBefore(LocalDate.now())){
            logger.error("Endtime cannot before now, endTime  = {}", classRoom.getEndTime());
            throw new BussinessException("Endtime cannot before now, endTime", "1002", HttpStatus.OK);
            // todo : 1002  -> move to constants
        }

        if(Objects.nonNull(classRoom.getStartTime())
                && classRoom.getStartTime().isAfter(LocalDate.now().plusYears(1))){
            logger.error("Startime cannot one year later from now, startTime  = {}", classRoom.getStartTime());
            throw new BussinessException("Startime cannot one year later from now, startTime ", "1003", HttpStatus.OK);
        }
    }

    @Override
    public PageDto search(ClassRoomSearchDto criteria) {
        var startTime = LocalDateTime.now();
        // todo  -> bo sung luong luu transaction_history

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
        // xu ly  bussiness -> luon luon su dung DTO
        transactionHistoryList.add(new TransactionHistory("admin",
                ActionType.SEARCH_CLASSROOM.name(),startTime));
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
