package com.cjc.main.servicei;

import com.cjc.main.model.Passenger;

public interface PassengerServiceI
{
	public Passenger savePassengerInfo(Passenger p);
	public Iterable<Passenger> getPassengers();
	public Passenger getPassengerById(int passengerId);
}
