package com.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.POJO.Credentials;

@Repository
public interface CredentialsRepository extends CrudRepository<Credentials, String> {

}
