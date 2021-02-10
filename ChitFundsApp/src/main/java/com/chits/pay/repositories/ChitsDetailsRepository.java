package com.chits.pay.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chits.pay.entity.ChitsDetailsEntity;

@Repository
public interface ChitsDetailsRepository extends CrudRepository<ChitsDetailsEntity, BigInteger>{

	@Query(value = "SELECT * FROM `chits_details` WHERE `admin_id` = (:adminId);", nativeQuery = true)
	List<ChitsDetailsEntity> getChitDetails(@Param("adminId") BigInteger adminId);
	
}
