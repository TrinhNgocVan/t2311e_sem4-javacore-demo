package org.aptech.t2311e.dto;

import lombok.Data;

@Data
public class ClassRoomSearchDto  extends PagingDto{
    private String name;
    private String code;
    private Integer currentSemester;
    // lop co hoc sinh voi  ten cu the
    private String studentContainName;
}
