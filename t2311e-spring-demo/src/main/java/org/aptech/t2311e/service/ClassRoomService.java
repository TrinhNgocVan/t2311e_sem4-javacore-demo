package org.aptech.t2311e.service;

import org.aptech.t2311e.dto.ClassRoomDto;
import org.aptech.t2311e.dto.ClassRoomSearchDto;
import org.aptech.t2311e.dto.PageDto;
import org.aptech.t2311e.exception.BussinessException;

public interface ClassRoomService {
    public PageDto search(ClassRoomSearchDto criteria);
    public boolean insert(ClassRoomDto classRoom) throws BussinessException;


}
