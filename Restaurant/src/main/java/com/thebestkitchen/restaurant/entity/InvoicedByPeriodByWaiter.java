package com.thebestkitchen.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table( schema = "Restaurant",  name="CNFacturadoXPeriodoXCamareros" )
@IdClass( value=InvoicedByPeriodByWaiterPK.class )
public class InvoicedByPeriodByWaiter {
	
	@Id
	@Column(name="IdCamarero")
 	private Integer waiterId;
	
	@Column(name="Camarero")
	private String waiter;
	
	@Id
	@Column(name="Periodo")
	private String period;
	
	@Column(name="Total")
	private String total;

	public Integer getWaiterId() {
		return waiterId;
	}

	public void setWaiterId(Integer waiterId) {
		this.waiterId = waiterId;
	}

	public String getWaiter() {
		return waiter;
	}

	public void setWaiter(String waiter) {
		this.waiter = waiter;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InvoicedByPeriodByWaiter [waiterId=");
		builder.append(waiterId);
		builder.append("],[waiter=");
		builder.append(waiter);
		builder.append("],[period=");
		builder.append(period);
		builder.append("],[total=");
		builder.append(total);
		builder.append("]");
		return builder.toString();
	}
}