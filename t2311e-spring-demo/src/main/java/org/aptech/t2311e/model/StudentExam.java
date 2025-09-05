//package org.aptech.t2311e.model;
//
//import jakarta.annotation.PostConstruct;
//import jakarta.persistence.Entity;
//
//import java.time.LocalDateTime;
//
//@Entity
//public class StudentExam {
//    private long id;
//    private String name;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
//    private String createdBy;
//    private String updatedBy;
//
//    @PostConstruct
//    private void preConstruct(){
//        System.err.println("bean student exam init success ");
//        this.createdAt = LocalDateTime.now();
//        this.createdBy = "ADMIN";
//    }
//}
