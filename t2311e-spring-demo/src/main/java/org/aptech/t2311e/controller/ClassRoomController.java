package org.aptech.t2311e.controller;

import org.aptech.t2311e.dto.ClassRoomDto;
import org.aptech.t2311e.dto.ClassRoomSearchDto;
import org.aptech.t2311e.dto.PageDto;
import org.aptech.t2311e.service.ClassRoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ClassRoomController {


    private static final Logger logger = LoggerFactory.getLogger(ClassRoomController.class);

    @Autowired
    ClassRoomService classRoomService;

    @PostMapping("/classrooms")
    public ResponseEntity<PageDto> search(@RequestBody ClassRoomSearchDto criteria){
        logger.debug("Search classroom by criteria : {}", criteria);
        return ResponseEntity.ok(classRoomService.search(criteria));
    }

    // Viết api thêm mới lớp có validate
    // (ví dụ trùng tên , mã lớp , thời gian bắt đầu ở tương lai ,
    // thời gian kết thúc ở quá khứ ...)

    @PostMapping("/clasroom")
    public ResponseEntity<?> add(@RequestBody ClassRoomDto classRoom){
        logger.info("Insert new classroom by code : {} , detail info {}",classRoom.getCode()
                , classRoom);
        return ResponseEntity.ok(null);
    }


}
