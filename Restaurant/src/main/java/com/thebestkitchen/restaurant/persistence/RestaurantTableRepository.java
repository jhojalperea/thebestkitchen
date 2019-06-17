package com.thebestkitchen.restaurant.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thebestkitchen.restaurant.entity.RestaurantTable;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Integer>{

	public List<RestaurantTable> findAllByOrderByTableId();
}
