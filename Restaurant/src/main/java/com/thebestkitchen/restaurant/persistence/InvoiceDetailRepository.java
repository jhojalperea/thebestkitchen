package com.thebestkitchen.restaurant.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thebestkitchen.restaurant.entity.InvoiceDetail;

public interface InvoiceDetailRepository  extends JpaRepository<InvoiceDetail, Integer>{

}
