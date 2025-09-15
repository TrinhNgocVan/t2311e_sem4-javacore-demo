package org.aptech.t2311e.controller;

import org.aptech.t2311e.dto.ClassRoomSearchDto;
import org.aptech.t2311e.dto.PageDto;
import org.aptech.t2311e.dto.StudentExamSearchDto;
import org.aptech.t2311e.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/class-room")
public class ClassRoomController {
    @Autowired
    ClassRoomService classRoomService;

    @PostMapping
    public ResponseEntity<PageDto> search(@RequestBody ClassRoomSearchDto criteria){
        return ResponseEntity.ok(classRoomService.search(criteria));
    }

}
