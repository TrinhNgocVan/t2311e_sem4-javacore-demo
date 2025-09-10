package org.aptech.t2311e.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class StudentExamSearchDto {
    private String name;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
    private int pageNumber;  // todo : move  -> class cha
    private int pageSize;
    ///  tim kiem theo khoang thoi gian tao moi va khoang thoi gian update
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdFrom;
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdTo;
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateFrom;
    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedTo;

}
