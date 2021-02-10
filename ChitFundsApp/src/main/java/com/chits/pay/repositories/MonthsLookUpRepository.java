package com.chits.pay.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chits.pay.entity.MonthsLookUpEntity;

@Repository
public interface MonthsLookUpRepository extends CrudRepository<MonthsLookUpEntity, BigInteger>{

	@Query(value = "SELECT * FROM `months_lkp` WHERE `month_year` = (:monthYear);", nativeQuery = true)
	MonthsLookUpEntity getMonthsDetails(@Param("monthYear") String monthYear);
	
}
