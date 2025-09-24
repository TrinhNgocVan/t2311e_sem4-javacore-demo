package org.aptech.t2311e.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
// todo : return this message when system get error
public class ErrorResponse {
    private String code;
    private String message;
    private LocalDateTime timestamp;
}
