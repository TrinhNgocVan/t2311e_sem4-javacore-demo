package org.aptech.t2311e.repository;

import org.aptech.t2311e.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<ClassRoom,Long>
, JpaSpecificationExecutor<ClassRoom> {
    List<ClassRoom> findByNameOrCode(String name, String code);
    boolean existsByNameOrCode(String name, String code);

}
