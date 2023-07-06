package com.emp.services;

import com.emp.entities.EmpEntity;
import com.emp.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    private EmpRepository empRepository;

//    public List<EmpEntity> getAllEmp(){
//        List<EmpEntity> empList=(List<EmpEntity>) this.empRepository.findAll();
//        return empList;
//    }
    public EmpEntity addEmp(EmpEntity emp) {

        return this.empRepository.save(emp);

    }

    public void deleteEmp(int id) {
        this.empRepository.deleteById(id);
    }

    public EmpEntity updateEmp(EmpEntity emp, int id) {
        emp.setId(id);
        EmpEntity updateEmp=this.empRepository.save(emp);
        return updateEmp;
    }


//    public List<EmpEntity> getEmpById(int id) {
//        return this.empRepository.findById(id);
//    }
//
//    public List<EmpEntity> getEmpByEname(String name) {
//        return this.empRepository.findByName(name);
//    }
//
//    public List<EmpEntity> getEmpByAge(int age) {
//        return this.empRepository.findByAge(age);
//    }
//
//    public List<EmpEntity> getEmpByGender(String gender) {
//        return this.empRepository.findByGender(gender);
//    }
//
//    public List<EmpEntity> getEmpByEidAndEname(int id,String name) {
//        return this.empRepository.findByIdAndName(id,name);
//    }
//
//    public List<EmpEntity> getEmpByEidAndEnameAndAge(int id,String name,int age) {
//        return this.empRepository.findByIdAndNameAndAge(id,name,age);
//    }


}
