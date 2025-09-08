package org.aptech.t2311e.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudentExamSearchDto {
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;
}
