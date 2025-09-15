package org.aptech.t2311e.specification;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.aptech.t2311e.dto.ClassRoomSearchDto;
import org.aptech.t2311e.dto.StudentExamSearchDto;
import org.aptech.t2311e.entity.ClassRoom;
import org.aptech.t2311e.entity.Student;
import org.aptech.t2311e.entity.StudentExam;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClassroomSpecification {
    public static Specification<ClassRoom> filter(ClassRoomSearchDto criteria){
        return (((root, query, cb) ->{
            Join<ClassRoom, Student> studentsJoin = root.join("students", JoinType.INNER);

            List<Predicate> predicates = new ArrayList<>();
            if(StringUtils.isNotEmpty(criteria.getCode())){
                predicates.add(cb.like(root.get("code"), "%"+ criteria.getCode().trim() +"%"));
            }
            if(StringUtils.isNotEmpty(criteria.getName())){
                predicates.add(cb.like(root.get("name"), "%"+ criteria.getName().trim() +"%"));
            }
            if(Objects.nonNull(criteria.getCurrentSemester())){
                predicates.add(cb.equal(root.get("currentSemester"), criteria.getCurrentSemester()));
            }
            if(StringUtils.isNotEmpty(criteria.getStudentContainName())){
                predicates.add(cb.like(studentsJoin.get("name"),
                        "%" + criteria.getStudentContainName().trim()+"%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));

        } ));
    }

//    public static Specification<StudentExam> filter(StudentExamSearchDto criteria){
//        return ((root, query, cb) -> {
//            // danh sach dk truy van tim kiem :
//            List<Predicate> predicates = new ArrayList<>();
//            // neu criteria.name != empty -> truy van theo name
//            if(StringUtils.isNotEmpty(criteria.getName())){
//                predicates.add(cb.like(cb.upper(root.get("name")), "%"+ criteria.getName().toUpperCase().trim()+"%"));
//            }
//            if(StringUtils.isNotEmpty(criteria.getCreatedBy())){
//                // fixme : text truyen vao la ten attribute model entity , ko phai la ten cot
//                predicates.add(cb.like(root.get("createdBy"), "%"+ criteria.getCreatedBy().trim()+"%"));
//            }
//            if(StringUtils.isNotEmpty(criteria.getUpdatedBy())){
//                predicates.add(cb.like(root.get("updatedBy"), "%"+ criteria.getUpdatedBy().trim()+"%"));
//            }
//            // TODO : bo sung logic tim kiem tao moi , cap nhat trong khoang thoi gian nhat dinh
//
//            /*
//            Ban ghi duoc tao trong 1 khoan thoi gian
//            1. createdFrom != null -> bo sung them dk created_at >= createdFrom
//            2. createdTo != null -> bo sung them dk created_To <= createdTo
//             */
//            if(Objects.nonNull(criteria.getCreatedFrom())){
//                predicates.add(cb.greaterThanOrEqualTo(root.get("createdAt"), criteria.getCreatedFrom()));
//            }
//            if(Objects.nonNull(criteria.getCreatedTo())){
//                predicates.add(cb.lessThanOrEqualTo(root.get("createdAt"), criteria.getCreatedTo()));
//            }
//            return cb.and(predicates.toArray(new Predicate[0]));
//        });
//    }
}
