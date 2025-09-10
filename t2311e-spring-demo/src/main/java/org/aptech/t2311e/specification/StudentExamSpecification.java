package org.aptech.t2311e.specification;

import jakarta.persistence.criteria.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.aptech.t2311e.dto.StudentExamSearchDto;
import org.aptech.t2311e.entity.StudentExam;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentExamSpecification {

    public static Specification<StudentExam> filter(StudentExamSearchDto criteria){
        return ((root, query, cb) -> {
            // danh sach dk truy van tim kiem :
            List<Predicate> predicates = new ArrayList<>();
            // neu criteria.name != empty -> truy van theo name
            if(StringUtils.isNotEmpty(criteria.getName())){
                predicates.add(cb.like(cb.upper(root.get("name")), "%"+ criteria.getName().toUpperCase().trim()+"%"));
            }
            if(StringUtils.isNotEmpty(criteria.getCreatedBy())){
                // fixme : text truyen vao la ten attribute model entity , ko phai la ten cot
                predicates.add(cb.like(root.get("createdBy"), "%"+ criteria.getCreatedBy().trim()+"%"));
            }
            if(StringUtils.isNotEmpty(criteria.getUpdatedBy())){
                predicates.add(cb.like(root.get("updatedBy"), "%"+ criteria.getUpdatedBy().trim()+"%"));
            }
            // TODO : bo sung logic tim kiem tao moi , cap nhat trong khoang thoi gian nhat dinh

            /*
            Ban ghi duoc tao trong 1 khoan thoi gian
            1. createdFrom != null -> bo sung them dk created_at >= createdFrom
            2. createdTo != null -> bo sung them dk created_To <= createdTo
             */
            if(Objects.nonNull(criteria.getCreatedFrom())){
                predicates.add(cb.greaterThanOrEqualTo(root.get("createdAt"), criteria.getCreatedFrom()));
            }
            if(Objects.nonNull(criteria.getCreatedTo())){
                predicates.add(cb.lessThanOrEqualTo(root.get("createdAt"), criteria.getCreatedTo()));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        });
    }

}
