package org.aptech.t2311e.controller;


import org.aptech.t2311e.dto.StudentExamDto;
import org.aptech.t2311e.entity.StudentExam;
import org.aptech.t2311e.service.StudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

// Restfull  , Soap ...
@RestController
@RequestMapping("/api/student/exam")
public class StudentExamController {
    @Autowired
    StudentExamService studentExamService;



//    public static void main(String[] args) {
//        StudentExamController studentExamController = new StudentExamController(); // POJO
//        /*
//        why ?
//        - ko can tight coupling code ( helloController = new HelloController();)
//        - de quan ly (lifecycle : init, destroy, sigleton or object pool)
//        - IOC quan ly bean  -> de quan ly hon (config, log, transaction)
//        config bean in spring :
//        1. annotation based
//        2. java config base
//        3. xml
//        Bean scope ?
//        singleton (mac dinh) : 1 bean duy nhat voi 1 IoC Container
//        prototype : moi lan goi  -> tao 1 bean moi
//        request : 1 request HTTP  -> tao ra 1 bean
//        session : 1 http session  -> tao ra 1 bean
//        ...
//        Bean LifeCycle ???
//        1. Tao instance
//        2. Inject bean  -> IoC container
//        3. call PostConstruct (post : sau , construct : khoi tao)
//        4. dung trong chuong trinh (IoC container truyen bean den cac noi goi no)
//        6. Khi dung chuong trinh hoac khi ko dung bean -> @PreDestroy
//         */
//    }

//    public static void main(String[] args) {
//        // c1
//        var studentExam = new StudentExamDto();
//        studentExam.setId(1L);
//        studentExam.setName("student1");
//        studentExam.setCreatedBy("admin");
//        studentExam.setUpdatedBy("admin");
//        studentExam.setCreatedAt(LocalDateTime.now());
//        studentExam.setUpdatedAt(LocalDateTime.now());
//        // c2
//        var studentExam2 = StudentExamDto.builder()
//                .id(1L)
//                .name("Student1")
//                .createdAt(LocalDateTime.now())
//                .updatedAt(LocalDateTime.now())
//                .createdBy("admin")
//                .updatedBy("admin")
//                .build();
//    }


//    @GetMapping()
//    public ResponseEntity<List<StudentExamDto>> getAll(){
//        return ResponseEntity.ok(studentExamService.getAll());
//    }

    @GetMapping("/{id}")
    public  ResponseEntity<StudentExamDto> get(@PathVariable Long id){
        return studentExamService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
//        StudentExamDto exam = studentExamService.getById(id);
//        if(Objects.isNull(exam)){
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(exam);

    }


}
