package com.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.POJO.EmployeeDetails;

@Repository
public interface EmployeeDetailsRepo extends CrudRepository<EmployeeDetails,String> {

}
