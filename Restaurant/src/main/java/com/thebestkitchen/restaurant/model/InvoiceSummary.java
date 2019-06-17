package com.thebestkitchen.restaurant.model;

import java.util.Date;

public class InvoiceSummary {
	
	private Integer invoiceId;
	
	private Date invoiceDate;
	
	private String client;
	
	private String waiter;
	
	private Integer tableId;
	
	private Integer numberProducts;
	
	private Integer totalInvoice;
	
	
	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getWaiter() {
		return waiter;
	}

	public void setWaiter(String waiter) {
		this.waiter = waiter;
	}

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public Integer getNumberProducts() {
		return numberProducts;
	}

	public void setNumberProducts(Integer numberProducts) {
		this.numberProducts = numberProducts;
	}

	public Integer getTotalInvoice() {
		return totalInvoice;
	}

	public void setTotalInvoice(Integer totalInvoice) {
		this.totalInvoice = totalInvoice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InvoiceSummary [invoiceId=");
		builder.append(invoiceId);
		builder.append("],[invoiceDate=");
		builder.append(invoiceDate);
		builder.append("],[client=");
		builder.append(client);
		builder.append("],[waiter=");
		builder.append(waiter);
		builder.append("],[tableId=");
		builder.append(tableId);
		builder.append("],[numberProducts=");
		builder.append(numberProducts);
		builder.append("],[totalInvoice=");
		builder.append(totalInvoice);
		builder.append("]");
		return builder.toString();
	}
}
