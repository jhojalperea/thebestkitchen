package com.thebestkitchen.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( schema = "Restaurant",  name="DetalleFactura" )
public class InvoiceDetail {

	@Column( name="IdFactura" )
	private Integer invoiceId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name="IdDetalleFactura" )
    private Integer invoiceDetailId;

    @Column( name="IdCocinero" )
    private Integer chefId;

    @Column( name="Plato" )
    private String plate;

    @Column( name="Importe" )
    private Integer amount;

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Integer getInvoiceDetailId() {
		return invoiceDetailId;
	}

	public void setInvoiceDetailId(Integer invoiceDetailId) {
		this.invoiceDetailId = invoiceDetailId;
	}

	public Integer getChefId() {
		return chefId;
	}

	public void setChefId(Integer chefId) {
		this.chefId = chefId;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InvoiceDetail [invoiceId=");
		builder.append(invoiceId);
		builder.append("],[invoiceDetailId=");
		builder.append(invoiceDetailId);
		builder.append("],[chefId=");
		builder.append(chefId);
		builder.append("],[plate=");
		builder.append(plate);
		builder.append("],[amount=");
		builder.append(amount);
		builder.append("]");
		return builder.toString();
	}	    
}
