package com.thebestkitchen.restaurant.persistence;

import java.util.List;

import com.thebestkitchen.restaurant.model.InvoiceSummary;

public interface InvoiceRepositoryCustom {

	public List<InvoiceSummary> findAllByOrderByInvoiceIdDesc();
}
