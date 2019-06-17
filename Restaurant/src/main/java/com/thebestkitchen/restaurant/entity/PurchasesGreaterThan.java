package com.thebestkitchen.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( schema = "Restaurant",  name="CNComprasClientesMayorQue" )
public class PurchasesGreaterThan {
	
	@Id
	@Column( name = "IdCliente" )
	private Integer clientId; 		
	
	@Column( name = "Cliente" )
	private String client; 
	
	@Column( name = "Total" )
	private Integer total;
	

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PurchasesGreaterThan [clientId=");
		builder.append(clientId);
		builder.append("],[client=");
		builder.append(client);
		builder.append("],[total=");
		builder.append(total);
		builder.append("]");
		return builder.toString();
	}	
}
