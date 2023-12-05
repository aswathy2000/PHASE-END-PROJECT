package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Citizen;
import com.example.demo.pojo.Vaccinationcenter;
import com.example.demo.repo.CitizenRepository;
import com.example.demo.repo.VaccinationcenterRepository;

@Service
public class CitizenService 
{

	@Autowired
	CitizenRepository cRepo;

	// INSERT INTO VaccinationCenter
	public Citizen insert(Citizen citizen) 
	{
		return cRepo.save(citizen);
	}


	//GET ALL RECORDS IN VaccinationCenter
	public List<Citizen> getall()
	{
		return cRepo.findAll();
	}


	//UPDATE RECORD IN VaccinationCenter
	public Citizen edit(Citizen citizen) 
	{
		return cRepo.save(citizen);
	}


	//DELETE RECORD IN VaccinationCenter
	public boolean deletebyid(int id) {
		cRepo.deleteById(id);
		return true;
	}

	//FIND RECORD BY ID 
	public Optional<Citizen> findbyID(int id)
	{	 
		return cRepo.findById(id);
	}

	//FIND RECORD BY NAME
	public List<Citizen> findbyName(Iterable<Integer> name)
	{	 
		return cRepo.findAllById(name);
	}

	//FIND VACCINATION CENTER 
	public List<Citizen> getCitizensByVaccinationcenter(Vaccinationcenter center) 
	{		
		return cRepo.findByVaccinationCenter(center);
	}

}
