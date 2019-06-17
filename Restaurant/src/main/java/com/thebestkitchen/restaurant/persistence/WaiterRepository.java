package com.thebestkitchen.restaurant.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thebestkitchen.restaurant.entity.Waiter;

public interface WaiterRepository extends JpaRepository<Waiter, Integer>{

	public List<Waiter> findAllByOrderByNameAscSurnameAsc();
}
