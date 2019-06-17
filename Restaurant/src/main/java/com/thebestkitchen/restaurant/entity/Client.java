package com.thebestkitchen.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="Cliente", schema="Restaurant" )
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name="IdCliente" )
	private Integer clientId;
	
	@Column( name="Nombre" )
	private String name;
	
	@Column( name="Apellido1" )
	private String surname;
	
	@Column( name="Apellido2" )
	private String secondSurname;
	
	@Column( name="Observaciones" )
	private String observations;

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
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

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Client [clientId=");
		builder.append(clientId);
		builder.append("],[name=");
		builder.append(name);
		builder.append("],[surname=");
		builder.append(surname);
		builder.append("],[secondSurname=");
		builder.append(secondSurname);
		builder.append("],[observations=");
		builder.append(observations);
		builder.append("]");
		return builder.toString();
	}
}
