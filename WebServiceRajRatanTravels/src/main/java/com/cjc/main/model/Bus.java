package com.cjc.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Bus 
{
	
	@Id
	private int busId;
	private String busName;
	private String departFrom;
	private String arriveTo;
	private double ticketPrice;
	private String journeyDate;
	private String busTime;
	
}
