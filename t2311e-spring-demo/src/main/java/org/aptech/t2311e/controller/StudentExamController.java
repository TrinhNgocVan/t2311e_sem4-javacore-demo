package org.aptech.t2311e.controller;


import org.apache.coyote.Response;
import org.aptech.t2311e.model.StudentExam;
import org.aptech.t2311e.service.StudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Restfull  , Soap ...
@RestController
//@Scope("prototype")
public class StudentExamController {
    @Autowired
    StudentExamService studentExamService;



    public static void main(String[] args) {
        StudentExamController studentExamController = new StudentExamController(); // POJO
        /*
        why ?
        - ko can tight coupling code ( helloController = new HelloController();)
        - de quan ly (lifecycle : init, destroy, sigleton or object pool)
        - IOC quan ly bean  -> de quan ly hon (config, log, transaction)
        config bean in spring :
        1. annotation based
        2. java config base
        3. xml
        Bean scope ?
        singleton (mac dinh) : 1 bean duy nhat voi 1 IoC Container
        prototype : moi lan goi  -> tao 1 bean moi
        request : 1 request HTTP  -> tao ra 1 bean
        session : 1 http session  -> tao ra 1 bean
        ...
        Bean LifeCycle ???
        1. Tao instance
        2. Inject bean  -> IoC container
        3. call PostConstruct (post : sau , construct : khoi tao)
        4. dung trong chuong trinh (IoC container truyen bean den cac noi goi no)
        6. Khi dung chuong trinh hoac khi ko dung bean -> @PreDestroy
         */
    }

    @GetMapping("/api/student/exams")
    public ResponseEntity<List<StudentExam>> getAll(){
        List<StudentExam> studentExams = studentExamService.getAll();
        return ResponseEntity.ok(studentExams);
    }

}
