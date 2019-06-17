package com.thebestkitchen.restaurant.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thebestkitchen.restaurant.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer>, InvoiceRepositoryCustom{

}
