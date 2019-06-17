package com.thebestkitchen.restaurant.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table( schema = "Restaurant",  name="Factura" )
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name="IdFactura" )
	private Integer invoiceId;
	
	@Column( name="IdCliente" )
	private Integer clientId;
	
	@Column( name="IdCamarero" )
	private Integer waiterId;
	
	@Column( name="IdMesa" )
	private Integer TableId;
	
	@CreatedDate
	@Column( name="FechaFactura" )
	private Date invoiceDate;

	
	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getWaiterId() {
		return waiterId;
	}

	public void setWaiterId(Integer waiterId) {
		this.waiterId = waiterId;
	}

	public Integer getTableId() {
		return TableId;
	}

	public void setTableId(Integer tableId) {
		TableId = tableId;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Invoice [invoiceId=");
		builder.append(invoiceId);
		builder.append("],[clientId=");
		builder.append(clientId);
		builder.append("],[waiterId=");
		builder.append(waiterId);
		builder.append("],[TableId=");
		builder.append(TableId);
		builder.append("],[invoiceDate=");
		builder.append(invoiceDate);
		builder.append("]");
		return builder.toString();
	}	
}
