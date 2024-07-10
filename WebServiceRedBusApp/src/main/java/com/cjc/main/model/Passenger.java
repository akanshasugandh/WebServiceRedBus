package com.cjc.main.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Passenger 
{
	@Id
	private int passengerId;
	private String passengerName;
	private int passengerAge;
	private String passengerGender;
	private String passengerEmailId;
	private long passengerPhoneNo;
	private String passengerStateOfResidence;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Bus passengerBusDetails;
}
