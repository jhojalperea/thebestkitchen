package com.thebestkitchen.restaurant.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thebestkitchen.restaurant.entity.Chef;

public interface ChefRepository extends JpaRepository<Chef, Integer>{

	public List<Chef> findAllByOrderByNameAscSurnameAsc();
}
