package com.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.POJO.Leaves;

@Repository
public interface LeavesRepo extends CrudRepository<Leaves,Integer > {

}
