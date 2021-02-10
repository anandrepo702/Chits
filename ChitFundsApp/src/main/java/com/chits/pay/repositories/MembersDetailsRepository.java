package com.chits.pay.repositories;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chits.pay.entity.MembersDetailsEntity;

@Repository
public interface MembersDetailsRepository extends CrudRepository<MembersDetailsEntity, BigInteger>{

	@Query(value = "SELECT * FROM `members_details` WHERE `chit_id` = (:chitId);", nativeQuery = true)
	List<MembersDetailsEntity> getMembersDetails(@Param("chitId") BigInteger chitId);
	
}
