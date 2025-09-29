package org.aptech.t2311e.repository;

import org.aptech.t2311e.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<ClassRoom,Long>
, JpaSpecificationExecutor<ClassRoom> {
    List<ClassRoom> findByNameOrCode(String name, String code);
    boolean existsByNameOrCode(String name, String code);
// truyen 1 list string code, 1 list string name ->
    @Query("Select c from  ClassRoom c where c.name in :names or c.code in :codes")
    List<ClassRoom> findByNamesOrCodes(@Param("names") List<String> names
    , @Param("codes") List<String> codes
    );

}
