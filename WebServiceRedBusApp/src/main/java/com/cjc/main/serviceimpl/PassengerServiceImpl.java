package com.cjc.main.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Passenger;
import com.cjc.main.repository.PassengerRepository;
import com.cjc.main.servicei.PassengerServiceI;

@Service
public class PassengerServiceImpl implements PassengerServiceI
{
	private @Autowired PassengerRepository pr;

	@Override
	public Passenger savePassengerInfo(Passenger p) {
		
		Passenger pas=pr.save(p);
		return pas;
	}

	@Override
	public Iterable<Passenger> getPassengers() {
		return pr.findAll();
	}

	@Override
	public Passenger getPassengerById(int passengerId) {
		Optional<Passenger> passengerOp=pr.findById(passengerId);
		Passenger pas=passengerOp.get();
		return pas;
	}
}
