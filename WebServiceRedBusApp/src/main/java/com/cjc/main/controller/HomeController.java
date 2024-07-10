package com.cjc.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cjc.main.model.Bus;
import com.cjc.main.model.Passenger;
import com.cjc.main.servicei.PassengerServiceI;

@RestController
public class HomeController 
{
	@Autowired
	RestTemplate restT;
	
	private @Autowired PassengerServiceI psi;
	
	@GetMapping("/getAllDataForRedBus")
	public List<Bus> getAllDataForRedBus() 
	{
		String url1="http://localhost:9011/getBuses";
		List<Bus> al1=restT.getForObject(url1, List.class);
		
		String url2="http://localhost:9022/getBuses";
		List<Bus> al2=restT.getForObject(url2, List.class);
		
		String url3="http://localhost:9033/getBuses";
		List<Bus> al3=restT.getForObject(url3, List.class);
		
		List<List<Bus>> allBusesList=new ArrayList();
		allBusesList.add(al1);
		allBusesList.add(al2);
		allBusesList.add(al3);
		
		//Retrieving data using JDK-8 lambda expression for each loop
		//allBusesList.forEach(BusList->{System.out.println(BusList);});
		 
		//with stream API we can implement all functions in one line store data in single list
		return allBusesList.stream().flatMap(a->a.stream()).toList();
	}
	
	@GetMapping("/getAllBusByName/{busName}")
	public List<Bus> getAllBusByName(@PathVariable String busName) 
	{
		String url1="http://localhost:9011/getBusesByName/" +busName;
		List<Bus> b1List=restT.getForObject(url1, List.class);
		
		String url2="http://localhost:9022/getBusesByName/" +busName;
		List<Bus> b2List=restT.getForObject(url2, List.class);
		
		String url3="http://localhost:9033/getBusesByName/" +busName;
		List<Bus> b3List=restT.getForObject(url3, List.class);
		
		List<List<Bus>> allBusesList=new ArrayList();
		
		allBusesList.add(b1List);
		allBusesList.add(b2List);
		allBusesList.add(b3List);
		
		return allBusesList.stream().flatMap(a->a.stream()).toList();
	}
	
	@GetMapping("/getAllBusByFrom/{departFrom}")
	public List<Bus> getAllBusByFrom(@PathVariable String departFrom) 
	{
		String url1="http://localhost:9011/getBusesByFrom/" +departFrom;
		List<Bus> b1List=restT.getForObject(url1, List.class);
		
		String url2="http://localhost:9022/getBusesByFrom/" +departFrom;
		List<Bus> b2List=restT.getForObject(url2, List.class);
		
		String url3="http://localhost:9033/getBusesByFrom/" +departFrom;
		List<Bus> b3List=restT.getForObject(url3, List.class);
		
		List<List<Bus>> allBusesList=new ArrayList();
		
		allBusesList.add(b1List);
		allBusesList.add(b2List);
		allBusesList.add(b3List);
		
		return allBusesList.stream().flatMap(a->a.stream()).toList();
	}
	
	@GetMapping("/getAllBusByTo/{arriveTo}")
	public List<Bus> getAllBusByTo(@PathVariable String arriveTo) 
	{
		String url1="http://localhost:9011/getBusesByTo/" +arriveTo;
		List<Bus> b1List=restT.getForObject(url1, List.class);
		
		String url2="http://localhost:9022/getBusesByTo/" +arriveTo;
		List<Bus> b2List=restT.getForObject(url2, List.class);
		
		String url3="http://localhost:9033/getBusesByTo/" +arriveTo;
		List<Bus> b3List=restT.getForObject(url3, List.class);
		
		List<List<Bus>> allBusesList=new ArrayList();
		
		allBusesList.add(b1List);
		allBusesList.add(b2List);
		allBusesList.add(b3List);
		
		return allBusesList.stream().flatMap(a->a.stream()).toList();
	}
	
	@GetMapping("/getAllBusByticketPrice/{ticketPrice}")
	public List<Bus> getAllBusByticketPrice(@PathVariable double ticketPrice) 
	{
		String url1="http://localhost:9011/getBusesByticketPrice/" +ticketPrice;
		List<Bus> b1List=restT.getForObject(url1, List.class);
		
		String url2="http://localhost:9022/getBusesByticketPrice/" +ticketPrice;
		List<Bus> b2List=restT.getForObject(url2, List.class);
		
		String url3="http://localhost:9033/getBusesByticketPrice/" +ticketPrice;
		List<Bus> b3List=restT.getForObject(url3, List.class);
		
		List<List<Bus>> allBusesList=new ArrayList();
		
		allBusesList.add(b1List);
		allBusesList.add(b2List);
		allBusesList.add(b3List);
		
		return allBusesList.stream().flatMap(a->a.stream()).toList();
	}
	
	@GetMapping("/getAllBusByDate/{journeyDate}")
	public List<Bus> getAllBusByDate(@PathVariable String journeyDate) 
	{
		String url1="http://localhost:9011/getBusesByDate/" +journeyDate;
		List<Bus> b1List=restT.getForObject(url1, List.class);
		
		String url2="http://localhost:9022/getBusesByDate/" +journeyDate;
		List<Bus> b2List=restT.getForObject(url2, List.class);
		
		String url3="http://localhost:9033/getBusesByDate/" +journeyDate;
		List<Bus> b3List=restT.getForObject(url3, List.class);
		
		List<List<Bus>> allBusesList=new ArrayList();
		
		allBusesList.add(b1List);
		allBusesList.add(b2List);
		allBusesList.add(b3List);
		
		return allBusesList.stream().flatMap(a->a.stream()).toList();
	}
	
	@GetMapping("/getAllBusByTime/{busTime}")
	public List<Bus> getAllBusByTime(@PathVariable String busTime) 
	{
		String url1="http://localhost:9011/getBusesByTime/" +busTime;
		List<Bus> b1List=restT.getForObject(url1, List.class);
		
		String url2="http://localhost:9022/getBusesByTime/" +busTime;
		List<Bus> b2List=restT.getForObject(url2, List.class);
		
		String url3="http://localhost:9033/getBusesByTime/" +busTime;
		List<Bus> b3List=restT.getForObject(url3, List.class);
		
		List<List<Bus>> allBusesList=new ArrayList();
		
		allBusesList.add(b1List);
		allBusesList.add(b2List);
		allBusesList.add(b3List);
		
		return allBusesList.stream().flatMap(a->a.stream()).toList();
	}
	
	@GetMapping("/getAllBusByFromTo/{departFrom}/{arriveTo}")
	public List<Bus> getAllBusByFromTo(@PathVariable String departFrom, @PathVariable String arriveTo) 
	{
		String url1="http://localhost:9011/getBusesByFromTo/" +departFrom+ "/" +arriveTo;
		List<Bus> b1List=restT.getForObject(url1, List.class);
		
		String url2="http://localhost:9022/getBusesByFromTo/" +departFrom+ "/" +arriveTo;
		List<Bus> b2List=restT.getForObject(url2, List.class);
		
		String url3="http://localhost:9033/getBusesByFromTo/" +departFrom+ "/" +arriveTo;
		List<Bus> b3List=restT.getForObject(url3, List.class);
		
		List<List<Bus>> allBusesList=new ArrayList();
		
		allBusesList.add(b1List);
		allBusesList.add(b2List);
		allBusesList.add(b3List);
		
		return allBusesList.stream().flatMap(a->a.stream()).toList();
	}
	
	@PostMapping("/savePassenger")
	public Passenger savePassenger(@RequestBody Passenger p)
	{
		Passenger pas=psi.savePassengerInfo(p);
		return pas;
	}
	
	@GetMapping("/getAllPassengers")
	public Iterable<Passenger> getAllPassengers()
	{
		Iterable<Passenger> passengersList=psi.getPassengers();
		return passengersList;
	}
	
	@GetMapping("/getPassengerById/{passengerId}")
	public Passenger getPassengerById(@PathVariable int passengerId)
	{
		Passenger pas=psi.getPassengerById(passengerId);
		return pas;
	}
	
}
