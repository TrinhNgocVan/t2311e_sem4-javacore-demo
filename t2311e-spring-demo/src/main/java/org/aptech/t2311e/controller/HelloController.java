package org.aptech.t2311e.controller;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.web.bind.annotation.RestController;

// Restfull  , Soap ...
@RestController
//@Scope("prototype")
public class HelloController {
    // POJO
    Thread a ;
    // init thread a when bean HelloController inited
    @PostConstruct
    public void initThreadA(){
        // init datasource
//        System.err.println("Init connection to datasource successfull");
        System.err.println("Init connection to datasource failed");
        System.exit(1);
    }
    @PreDestroy
    public void returnThreadA(){
        System.err.println("Bean HelloController destroy successful");
    }


    public static void main(String[] args) {
        HelloController helloController = new HelloController(); // POJO
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

//    @GetMapping("/api/hello")
    public String helloApi(){
        return "Hello World";
    }

}
