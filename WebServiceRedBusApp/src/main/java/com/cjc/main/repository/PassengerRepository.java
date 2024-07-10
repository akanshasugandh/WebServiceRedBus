package com.cjc.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.main.model.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> 
{

}
