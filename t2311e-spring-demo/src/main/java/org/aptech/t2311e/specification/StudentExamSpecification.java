package org.aptech.t2311e.specification;

import jakarta.persistence.criteria.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.aptech.t2311e.dto.StudentExamSearchDto;
import org.aptech.t2311e.entity.StudentExam;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class StudentExamSpecification {

    public static Specification<StudentExam> filter(StudentExamSearchDto criteria){
        return ((root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            // neu criteria.name != empty -> truy van theo name
            if(StringUtils.isNotEmpty(criteria.getName())){
                cb.like(root.get("name"), "%"+ criteria.getName().trim()+"%");
            }
            if(StringUtils.isNotEmpty(criteria.getCreatedBy())){
                cb.like(root.get("created_by"), "%"+ criteria.getCreatedBy().trim()+"%");
            }
            if(StringUtils.isNotEmpty(criteria.getUpdatedBy())){
                cb.like(root.get("updated_by"), "%"+ criteria.getUpdatedBy().trim()+"%");
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        });
    }

}
