package com.thebestkitchen.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="Camarero", schema="Restaurant" )
public class Waiter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name="IdCamarero" )
	private Integer waiterId;
	
	@Column( name="Nombre" )
	private String name;
	
	@Column( name="Apellido1" )
	private String surname;
	
	@Column( name="Apellido2" )
	private String secondSurname;

	public Integer getWaiterId() {
		return waiterId;
	}

	public void setWaiterId(Integer waiterId) {
		this.waiterId = waiterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Waiter [waiterId=");
		builder.append(waiterId);
		builder.append("],[name=");
		builder.append(name);
		builder.append("],[surname=");
		builder.append(surname);
		builder.append("],[secondSurname=");
		builder.append(secondSurname);
		builder.append("]");
		return builder.toString();
	}
}
