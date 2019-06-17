package com.thebestkitchen.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="Mesa", schema="Restaurant" )
public class RestaurantTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name="IdMesa" )
	private Integer tableId;
	
	@Column( name="NumMaxComensales" )
	private Integer maxNumberDiners;
	
	@Column( name="Ubicacion" )
	private String location;
	

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public Integer getMaxNumberDiners() {
		return maxNumberDiners;
	}

	public void setMaxNumberDiners(Integer maxNumberDiners) {
		this.maxNumberDiners = maxNumberDiners;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RestaurantTable [tableId=");
		builder.append(tableId);
		builder.append("],[maxNumberDiners=");
		builder.append(maxNumberDiners);
		builder.append("],[location=");
		builder.append(location);
		builder.append("]");
		return builder.toString();
	}
}
