package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Vaccinationcenter;
import com.example.demo.repo.VaccinationcenterRepository;

@Service
public class VaccinationcenterService 
{
	@Autowired
	private VaccinationcenterRepository vcRepo;

	// INSERT INTO VaccinationCenter
	public Vaccinationcenter insert(Vaccinationcenter center) 
	{
		return vcRepo.save(center);
	}
	
	
	//GET ALL RECORDS IN VaccinationCenter
	public List<Vaccinationcenter> getall()
	{
		return vcRepo.findAll();
	}
	
	
	//UPDATE RECORD IN VaccinationCenter
	public Vaccinationcenter edit(Vaccinationcenter center) 
	{
		return vcRepo.save(center);
	}
	
	
	//DELETE RECORD IN VaccinationCenter
	public boolean deletebyid(int id) {
		vcRepo.deleteById(id);
		return true;
	}
	
	//FIND RECORD BY ID IN VaccinationCenter
	public Optional<Vaccinationcenter> findbyID(int id)
	{	 
		return vcRepo.findById(id);
	}
}
