package com.thebestkitchen.restaurant.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thebestkitchen.restaurant.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

	public List<Client> findAllByOrderByNameAscSurnameAsc();
}
