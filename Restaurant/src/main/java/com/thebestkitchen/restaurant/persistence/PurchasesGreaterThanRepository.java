package com.thebestkitchen.restaurant.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thebestkitchen.restaurant.entity.PurchasesGreaterThan;

public interface PurchasesGreaterThanRepository extends JpaRepository<PurchasesGreaterThan, Integer>{

	public List<PurchasesGreaterThan> findAllByOrderByTotalDesc();
	

}