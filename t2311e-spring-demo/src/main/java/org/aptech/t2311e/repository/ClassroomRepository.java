package org.aptech.t2311e.repository;

import org.aptech.t2311e.entity.ClassRoom;
import org.aptech.t2311e.entity.StudentExam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<ClassRoom,Long>
, JpaSpecificationExecutor<ClassRoom> {
}
