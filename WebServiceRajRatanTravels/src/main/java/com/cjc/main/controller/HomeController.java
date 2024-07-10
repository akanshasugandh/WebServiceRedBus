package com.cjc.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.model.Bus;
import com.cjc.main.servicei.BusServiceI;

@RestController
public class HomeController 
{
	private @Autowired BusServiceI bsi;
	
	@PostMapping("/postBus")
	public Bus regBusData(@RequestBody Bus b)
	{
		System.out.println("Bus Id: "+b.getBusId());
		System.out.println("Bus name: "+b.getBusName());
		System.out.println("Bus journey start from: "+b.getDepartFrom());
		System.out.println("Bus journey end: "+b.getArriveTo());
		System.out.println("Bus ticket price: "+b.getTicketPrice());
		System.out.println("Bus journey date: "+b.getJourneyDate());
		System.out.println("Bus departure time: "+b.getBusTime());
		Bus bs=bsi.regBusInfo(b);
		return bs;
	}
	
	@GetMapping("/getBuses")
	public Iterable<Bus> getAllBusesData()
	{
		Iterable<Bus> list_bus=bsi.getAllBusesInfo();
		return list_bus;
	}
	
	@PutMapping("/updateBus/{busId}")
	public String updateBus(@PathVariable int busId, @RequestBody Bus b)
	{
		bsi.updateBusInfo(busId, b);
		return "Data updated successfully!";
	}
	
	@DeleteMapping("/deleteBus/{busId}")
	public String deleteBus(@PathVariable int busId)
	{
		bsi.deleteBusInfo(busId);
		return "Data deleted successfully!";
	}
	
	@PatchMapping("/modifyBusTime/{busId}")
	public String modifybusTime(@PathVariable int busId, @RequestBody Bus b)
	{
		bsi.modifybusTime(busId, b);
		return "Bus timing has been modified!";
	}
	
	@GetMapping("/getBusById/{busId}")
	public Bus getSingleBusById(@PathVariable int busId)
	{
		Bus bs=bsi.getSingleBusInfoById(busId);
		return bs;
	}
	
	@GetMapping("/getBusesByName/{busName}")
	public  List<Bus> getAllBusByName(@PathVariable String busName)
	{
		List<Bus> busList=bsi.getAllBusInfoBybusName(busName);
		return busList;
	}
	
	@GetMapping("/getBusesByFrom/{departFrom}")
	public  List<Bus> getAllBusByFrom(@PathVariable String departFrom)
	{
		List<Bus> busList=bsi.getAllBusInfoBydepartFrom(departFrom);
		return busList;
	}
	
	@GetMapping("/getBusesByTo/{arriveTo}")
	public  List<Bus> getAllBusByTo(@PathVariable String arriveTo)
	{
		List<Bus> busList=bsi.getAllBusInfoByarriveTo(arriveTo);
		return busList;
	}
	
	@GetMapping("/getBusesByticketPrice/{ticketPrice}")
	public  List<Bus> getAllBusByticketPrice(@PathVariable double ticketPrice)
	{
		List<Bus> busList=bsi.getAllBusInfoByticketPrice(ticketPrice);
		return busList;
	}
	
	@GetMapping("/getBusesByDate/{journeyDate}")
	public Iterable<Bus> getAllBusByDate(@PathVariable String journeyDate)
	{
		Iterable<Bus> busList=bsi.getAllBusInfoByjourneyDate(journeyDate);
		return busList;
	}
	
	@GetMapping("/getBusesByTime/{busTime}")
	public  List<Bus> getAllBusByTime(@PathVariable String busTime)
	{
		List<Bus> busList=bsi.getAllBusInfoBybusTime(busTime);
		return busList;
	}
	
	@GetMapping("/getBusesByFromTo/{departFrom}/{arriveTo}")
	public  List<Bus> getAllBusByFromTo(@PathVariable String departFrom, @PathVariable String arriveTo)
	{
		List<Bus> busList=bsi.getAllBusInfoByFromTo(departFrom, arriveTo);
		return busList;
	}


}
