package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.pojo.Citizen;
import com.example.demo.pojo.Vaccinationcenter;
import com.example.demo.service.CitizenService;

@Controller
public class CitizenController {

	@Autowired
	CitizenService service;

	@RequestMapping("/insertcitizen")
	public ModelAndView insertrecord(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView mv = new ModelAndView();

		Citizen citizen = new Citizen();
		citizen.setPersonName(request.getParameter("name"));
		Vaccinationcenter vc = new Vaccinationcenter();

		String city = request.getParameter("centercity");
		String centerName = request.getParameter("vaccinationcenter");

		vc.setVaccinationCenterCity(city);
		vc.setVaccinationCenterName(centerName);
		int noofdoses = Integer.parseInt(request.getParameter("noOfDoses"));
		citizen.setNumberOfDoses(noofdoses);
		citizen.setVaccinationStatus(noofdoses);
		citizen.setVaccinationCenter(vc);

		if(service.insert(citizen)!=null) 
		{
			mv.setViewName("displaycitizen.jsp");
		}
		return mv;
	}

	@RequestMapping("/getallcitizen")
	public ModelAndView getall(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView mv = new ModelAndView();

		List<Citizen> list=service.getall();
		mv.setViewName("citizen.jsp");
		mv.addObject("list",list);

		return mv;
	}


	@RequestMapping("/deletecitizen")
	public ModelAndView delete(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView mv = new ModelAndView();

		int id = Integer.parseInt(request.getParameter("id"));
		boolean status =service.deletebyid(id);
		mv.setViewName("dashboard.jsp");

		return mv;
	}

	@RequestMapping("/editcitizen")
	public ModelAndView editrecord(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView mv = new ModelAndView();

		Citizen citizen = new Citizen();
		int id = Integer.parseInt(request.getParameter("id"));
		citizen.setId(id);

		citizen.setPersonName(request.getParameter("name"));
		Vaccinationcenter vc = new Vaccinationcenter();

		String city = request.getParameter("centercity");
		String centerName = request.getParameter("vaccinationcenter");

		vc.setVaccinationCenterCity(city);
		vc.setVaccinationCenterName(centerName);
		int noofdoses = Integer.parseInt(request.getParameter("noOfDoses"));
		citizen.setNumberOfDoses(noofdoses);
		citizen.setVaccinationStatus(noofdoses);
		citizen.setVaccinationCenter(vc);

		if(service.edit(citizen)!=null) 
		{
			mv.setViewName("displaycitizen.jsp");
		}
		return mv;
	}

	@RequestMapping("/viewcitizen")
	public ModelAndView viewMethod(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView mv = new ModelAndView();

		int id = Integer.parseInt(request.getParameter("id"));

		Optional<Citizen> vc = service.findbyID(id);
		if(vc.isPresent()) 
		{
			Citizen c = vc.get();
			mv.setViewName("viewcitizen.jsp");
			mv.addObject("center",c);
		}
		return mv;
	}

}
