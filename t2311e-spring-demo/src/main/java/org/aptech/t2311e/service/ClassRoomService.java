package org.aptech.t2311e.service;

import org.aptech.t2311e.dto.ClassRoomDto;
import org.aptech.t2311e.dto.ClassRoomSearchDto;
import org.aptech.t2311e.dto.PageDto;
import org.aptech.t2311e.exception.BussinessException;

import java.util.List;

public interface ClassRoomService {
    PageDto search(ClassRoomSearchDto criteria);
    boolean insert(ClassRoomDto classRoom) throws BussinessException;
    boolean insert(List<ClassRoomDto> classRoom) throws BussinessException;


}
