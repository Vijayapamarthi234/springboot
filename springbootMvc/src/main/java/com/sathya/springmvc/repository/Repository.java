package com.sathya.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sathya.springmvc.entity.Productentity;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Productentity, Long> {

}
  