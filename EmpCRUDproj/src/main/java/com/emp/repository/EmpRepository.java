package com.emp.repository;

import com.emp.entities.EmpEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpRepository extends JpaRepository<EmpEntity, Integer>, JpaSpecificationExecutor<EmpEntity> {

//    public List<EmpEntity> findById(int id);
//    public List<EmpEntity> findByName(String name);
//    public List<EmpEntity> findByAge(int age);
//    public List<EmpEntity> findByGender(String gender);
//
//    public List<EmpEntity> findByIdAndName(int id,String name);
//
//    @Query(value="SELECT * FROM tbl_emp WHERE emp_id= :id AND emp_name= :name AND emp_age= :age", nativeQuery = true)
//    abstract public List<EmpEntity> findByIdAndNameAndAge(int id,String name,int age);


//    public List<EmpEntity> findAll(Specification<EmpEntity> spec);
}
