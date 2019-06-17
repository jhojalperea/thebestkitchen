package com.thebestkitchen.restaurant.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thebestkitchen.restaurant.entity.InvoicedByPeriodByWaiter;

public interface InvoicedByPeriodByWaiterRepository extends JpaRepository<InvoicedByPeriodByWaiter, Integer>{
	
	public List<InvoicedByPeriodByWaiter> findAllByPeriodBetweenOrderByPeriodAscWaiterAsc( String periodFrom, String periodTo );
}
