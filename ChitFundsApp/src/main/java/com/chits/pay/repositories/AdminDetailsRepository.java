package com.chits.pay.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chits.pay.entity.AdminDetailsEntity;

@Repository
public interface AdminDetailsRepository extends CrudRepository<AdminDetailsEntity, BigInteger>{

	@Query(value = "SELECT * FROM `admin_details` WHERE `mobile_no` = (:mobileNumber) OR `email_id` = (:emailId);", nativeQuery = true)
	List<AdminDetailsEntity> getExistingAdminDetails(@Param("mobileNumber") String mobileNumber,@Param("emailId") String emailId);
	
	@Query(value = "SELECT * FROM `admin_details` WHERE `email_id` = (:emailId) AND `password` = (:password);", nativeQuery = true)
	AdminDetailsEntity validateLogin(@Param("emailId") String emailId,@Param("password") String password);
	
}
