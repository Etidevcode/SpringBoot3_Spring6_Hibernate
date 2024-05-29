package com.etienne.cruddemo.dao;

import com.etienne.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


// @RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// That's it ... no need to write any code LOL!
}
