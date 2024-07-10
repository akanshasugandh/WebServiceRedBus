package com.cjc.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cjc.main.model.Bus;

import jakarta.transaction.Transactional;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer>
{
	@Transactional
	@Modifying
	@Query(name = "updateBusBybusId", value = "update Bus set busName=?1, departFrom=?2, arriveTo=?3, ticketPrice=?4, "
			+ "journeyDate=?5, busTime=?6 where busId=?7")
	public void updateBusBybusId(String busName, String departFrom, String arriveTo, 
			double ticketPrice, String journeyDate, String busTime, int busId);
	
	@Transactional
	@Modifying
	@Query(name = "deleteBybusId", value = "delete from Bus where busId=?1")
	public void deleteBybusId(int busId);
	
	@Transactional
	@Modifying
	@Query(name = "modifyBusTime", value = "update Bus set busTime=?1 where busId=?2")
	public void modifyBusTime(String busTime, int busId);
	
	@Query(name = "getBybusName", value = "from Bus where busName=?1")
	public List<Bus> getBybusName(String busName);
	
	@Query(name = "getBydepartFrom", value = "from Bus where departFrom=?1")
	public List<Bus> getBydepartFrom(String departFrom);
	
	@Query(name = "getByarriveTo", value = "from Bus where arriveTo=?1")
	public List<Bus> getByarriveTo(String arriveTo);
	
	@Query(name = "getByticketPrice", value = "from Bus where ticketPrice=?1")
	public List<Bus> getByticketPrice(double ticketPrice);
	
	@Query(name = "getByjourneyDate", value = "from Bus where journeyDate=?1")
	public List<Bus> getByjourneyDate(String journeyDate);
	
	@Query(name = "getBybusTime", value = "from Bus where busTime=?1")
	public List<Bus> getBybusTime(String busTime);
	
	@Query(name = "getByFromTo", value = "from Bus where departFrom=?1 and arriveTo=?2")
	public List<Bus> getByFromTo(String departFrom, String arriveTo);
}
