package com.thuexcursion.crud.repository;



//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.thuexcursion.crud.model.Admin;

/*
 * This interface extends JpaRepository which contains the api of basic CRUD operations, pagination and sorting
 * In this way, boilerplate code like sql statements do not need to be written explicitly 
 * */

public interface AdminRepository extends JpaRepository<Admin,Integer> {

	@Query(value="select l from login l where username = :username and password = :password", nativeQuery = true)
    Admin login(String username, String password);

	//Admin findByUsername(String username);

	//Optional<Admin> findByUsername(int username);

}
