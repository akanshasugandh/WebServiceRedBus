package com.cjc.main.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Bus;
import com.cjc.main.repository.BusRepository;
import com.cjc.main.servicei.BusServiceI;

import jakarta.transaction.Transactional;

@Service
public class BusServiceImpl implements BusServiceI {

	@Autowired
	private BusRepository br;

	//create
	@Override
	public Bus regBusInfo(Bus b) {
		Bus bs = br.save(b);
		return bs;
	}

	//read
	@Override
	public Iterable<Bus> getAllBusesInfo() {
		return br.findAll();
	}

	//update
	@Override
	public String updateBusInfo(int busId, Bus b) {
		Optional<Bus> opBus = br.findById(busId);
		if (opBus.isPresent()) {
			br.updateBusBybusId(b.getBusName(), b.getDepartFrom(), b.getArriveTo(), b.getTicketPrice(),
					b.getJourneyDate(), b.getBusTime(), busId);
			return "Data updated successfully";
		} else {
			throw new RuntimeException("User with id: " + busId + " is not present");
		}
	}

	//delete
	@Transactional
	@Override
	public String deleteBusInfo(int busId) {
		Optional<Bus> opBus = br.findById(busId);
		if (opBus.isPresent()) {
			br.deleteBybusId(busId);
			return "Data deleted successfully";
		} else {
			throw new RuntimeException("User with id: " + busId + " is not present");
		}
	}

	@Override
	public String modifybusTime(int busId, Bus b) {
		Optional<Bus> busOp = br.findById(busId);
		if (busOp.isPresent()) {
			br.modifyBusTime(b.getBusTime(), busId);
			return "Bus timing changed successfully";
		} else {
			throw new RuntimeException("User with id: " + busId + " is not present");
		}
	}

	// Get bus by busId
	@Override
	public Bus getSingleBusInfoById(int busId) {
		Optional<Bus> busOp = br.findById(busId);
		Bus bs = busOp.get();
		return bs;
	}
	
	// Get bus list by bus name
	@Override
	public List<Bus> getAllBusInfoBybusName(String busName) 
	{
		List<Bus> busList = br.getBybusName(busName);
		return busList.stream().sorted((b1, b2) -> b1.getBusName().compareTo(b2.getBusName())).toList();
	}

	// Get bus list by departure from
	@Override
	public List<Bus> getAllBusInfoBydepartFrom(String departFrom)
	{
		List<Bus> busList = br.getBydepartFrom(departFrom);
		return busList.stream().sorted((b1, b2) -> b1.getDepartFrom().compareTo(b2.getDepartFrom())).toList();
	}

	// Get bus list by arrive to
	@Override
	public List<Bus> getAllBusInfoByarriveTo(String arriveTo) {
		List<Bus> busList = br.getByarriveTo(arriveTo);
		return busList.stream().sorted((b1, b2) -> b1.getArriveTo().compareTo(b2.getArriveTo())).toList();
	}

	// Get bus list by ticket Price
	@Override
	public List<Bus> getAllBusInfoByticketPrice(double ticketPrice) {
		List<Bus> busList = br.getByticketPrice(ticketPrice);
		return busList.stream().sorted((b1, b2) -> (int)b1.getTicketPrice()-(int)b2.getTicketPrice()).toList();
	}

	// Get bus list by journey date
	@Override
	public List<Bus> getAllBusInfoByjourneyDate(String journeyDate)
	{
		List<Bus> busList = br.getByjourneyDate(journeyDate);
		return busList.stream().sorted((b1, b2) -> b1.getJourneyDate().compareTo(b2.getJourneyDate())).toList();
	}
	
	// Get bus list by bus time
	@Override
	public List<Bus> getAllBusInfoBybusTime(String busTime) {
		List<Bus> busList = br.getBybusTime(busTime);
		return busList.stream().sorted((b1, b2) -> b1.getBusTime().compareTo(b2.getBusTime())).toList();
	}
	
	// Get bus list by bus From and to
	@Override
	public List<Bus> getAllBusInfoByFromTo(String departFrom, String arriveTo) {
		List<Bus> busList = br.getByFromTo(departFrom, arriveTo);
		return busList.stream().toList();
	}

}