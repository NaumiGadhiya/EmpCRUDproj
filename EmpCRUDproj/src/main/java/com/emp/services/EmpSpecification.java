package com.emp.services;

import com.emp.entities.EmpEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmpSpecification {

    public static Specification<EmpEntity> serachByEmp(EmpEntity empEntity){
        return ((root, query, criteriaBuilder) -> {

            List<Predicate> predicateList=new ArrayList<>();
           if (empEntity.getId()!=null){
               predicateList.add(criteriaBuilder.equal(root.get("id"),empEntity.getId()));
           }
           if (empEntity.getName()!=null){
                predicateList.add(criteriaBuilder.equal(root.get("name"),empEntity.getName()));
           }
            if (empEntity.getAge()!=null){
                predicateList.add(criteriaBuilder.equal(root.get("age"),empEntity.getAge()));
            }
           if (empEntity.getGender()!=null){
                predicateList.add(criteriaBuilder.equal(root.get("gender"),empEntity.getGender()));
           }
            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        });

    }
}

//@Component
//public class EmpSpecification {
//
//    public static Specification<EmpEntity> searchById(int id) {
//        return ((root, query, criteriaBuilder) -> {
//            return criteriaBuilder.equal(root.get("id"),id);
//        });
//    }
//    public static Specification<EmpEntity> searchByName(String name) {
//        return ((root, query, criteriaBuilder) -> {
//            return criteriaBuilder.equal(root.get("name"),name);
//        });
//    }
//    public static Specification<EmpEntity> searchByAge(int age) {
//        return ((root, query, criteriaBuilder) -> {
//            return criteriaBuilder.equal(root.get("age"),age);
//        });
//    }
//    public static Specification<EmpEntity> searchByGender(String gender) {
//        return ((root, query, criteriaBuilder) -> {
//            return criteriaBuilder.equal(root.get("gender"),gender);
//        });
//    }

//}