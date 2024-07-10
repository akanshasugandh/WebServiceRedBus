package com.cjc.main.servicei;

import java.util.List;

import com.cjc.main.model.Bus;

public interface BusServiceI 
{
	public Bus regBusInfo(Bus b);
	public Iterable<Bus> getAllBusesInfo();
	public String updateBusInfo(int busId, Bus b);
	public String deleteBusInfo(int busId);
	
	public String modifybusTime(int busId, Bus b);
	
	public Bus getSingleBusInfoById(int busId);
	public List<Bus> getAllBusInfoBybusName(String busName);
	public List<Bus> getAllBusInfoBydepartFrom(String departFrom);
	public List<Bus> getAllBusInfoByarriveTo(String arriveTo);
	public List<Bus> getAllBusInfoByticketPrice(double ticketPrice);
	public List<Bus> getAllBusInfoByjourneyDate(String journeyDate);
	public List<Bus> getAllBusInfoBybusTime(String busTime);
	
	public List<Bus> getAllBusInfoByFromTo(String departFrom, String arriveTo);
	
}
