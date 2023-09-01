package com.jsp.Airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Airline.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

}
