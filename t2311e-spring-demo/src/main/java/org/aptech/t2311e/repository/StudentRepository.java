package org.aptech.t2311e.repository;

import org.aptech.t2311e.dto.ClassroomProjectionDto;
import org.aptech.t2311e.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long>
        , JpaSpecificationExecutor<Student> {

    // when start ioc container  -> compile
    Long countByclassRoom_Id(Long classId);
    @Query("select count(s) from Student s where s.classRoom.Id = :classId")
    Long countByClassId(@Param("classId") Long classid);
    @Query(value = "select * from student_table ...." ,nativeQuery = true)
    ClassroomProjectionDto calculateStudent();

//    @Query("select count(s.id), s.classroom.Id from Student s group by s.classroom where s.classromm.Id in (:classIds)")
//    Map<Long,Long> countByClassIds(@Param("classIds") List<Long> classIds);


}