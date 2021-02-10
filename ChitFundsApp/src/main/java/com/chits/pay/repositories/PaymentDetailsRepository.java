package com.chits.pay.repositories;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chits.pay.entity.PaymentDetailsEntity;

@Repository
public interface PaymentDetailsRepository extends CrudRepository<PaymentDetailsEntity, BigInteger>{

	@Query(value = "SELECT * FROM `payment_details` WHERE `member_id` = (:memberId);", nativeQuery = true)
	List<PaymentDetailsEntity> getPaymentDetails(@Param("memberId") BigInteger memberId);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE `payment_details` SET `amount_paid` = (:amountPaid), `chit_drawn_or_not` = (:chitWithDrawnOrNot) WHERE `payment_id` = (:paymentId);", nativeQuery = true)
	void updatePaymentDetails(@Param("amountPaid") BigInteger amountPaid, @Param("chitWithDrawnOrNot") Boolean chitWithDrawnOrNot, @Param("paymentId") BigInteger paymentId);
	
}
