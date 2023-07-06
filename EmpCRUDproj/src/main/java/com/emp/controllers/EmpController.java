package com.emp.controllers;

import com.emp.entities.EmpEntity;
import com.emp.repository.EmpRepository;
import static com.emp.services.EmpSpecification.*;

import com.emp.services.EmpService;
import com.emp.services.EmpSpecification;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.data.jpa.domain.Specification.*;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

@RequestMapping("/employee")
public class EmpController {

    @Autowired
    private EmpRepository empRepository;

    @Autowired
	private EmpService empService;

	@GetMapping
	public List<EmpEntity> getAllEmps(){
		return empRepository.findAll();
	}

	@PostMapping
	public List<EmpEntity> getEmps(@RequestBody EmpEntity empEntity)  {
		Specification<EmpEntity> specification= EmpSpecification.serachByEmp(empEntity);
		List<EmpEntity> emp = empRepository.findAll(specification);
		return emp;
	}

//	@PostMapping
//	public List<EmpEntity> getEmps(@RequestParam(required = false) Integer id,
//								   @RequestParam(required = false) String name,
//								   @RequestParam(required = false) Integer age)  {
//		if(id!=null && name!=null && age!=null){
//			return empRepository.findAll(where(searchById(id).and(searchByName(name).and(searchByAge(age)))));
//		}
//		else if(id!=null && name!=null){
//			return empRepository.findAll(where(searchById(id).and(searchByName(name))));
//		}
//		else if(id!=null){
//			return empRepository.findAll(where(searchById(id)));
//		}
//		else if(name!=null){
//			return empRepository.findAll(where(searchByName(name)));
//		}
//		else if(age!=null){
//			return empRepository.findAll(where(searchByAge(age)));
//		}
//
//		return empRepository.findAll();
//	}

	@PostMapping("/add")
	public EmpEntity addEmp(@Valid @RequestBody EmpEntity emp) {
		return this.empService.addEmp(emp);
	}

	@PutMapping("/{id}")
	public EmpEntity updateEmp(@Valid @RequestBody EmpEntity emp, @PathVariable("id") int id) {
		return this.empService.updateEmp(emp, id);
	}

	@DeleteMapping("/{id}")
	public String deleteEmp(@PathVariable("id") int id) {
		this.empService.deleteEmp(id);
		return "data deleted";
	}
}
