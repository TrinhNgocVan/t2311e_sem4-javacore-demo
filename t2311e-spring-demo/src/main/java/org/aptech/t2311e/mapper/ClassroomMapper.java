package org.aptech.t2311e.mapper;

import org.aptech.t2311e.dto.ClassRoomDto;
import org.aptech.t2311e.dto.StudentDto;
import org.aptech.t2311e.entity.ClassRoom;
import org.aptech.t2311e.entity.Student;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ClassroomMapper {
    public ClassRoom dtoToEntity(ClassRoomDto dto){
        ClassRoom c = new ClassRoom();
        BeanUtils.copyProperties(dto,c);
        return c;
    };
    public  ClassRoomDto entityToDto(ClassRoom entity){
        ClassRoomDto dto  = new ClassRoomDto();
        BeanUtils.copyProperties(entity,dto);

        // dto.setStudents(entity.getStudent())
        return dto;
    }
}
