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
import com.example.demo.service.VaccinationcenterService;
@Controller
public class VaccinationcenterController {

	@Autowired
	VaccinationcenterService service;

	@Autowired
	CitizenService cservice;

	@RequestMapping("/insert")
	public ModelAndView insertrecord(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView mv = new ModelAndView();

		Vaccinationcenter vc = new Vaccinationcenter();
		vc.setVaccinationCenterName(request.getParameter("centername"));
		vc.setVaccinationCenterCity(request.getParameter("centercity"));
		if(service.insert(vc)!=null) 
		{
			mv.setViewName("display.jsp");
		}
		return mv;
	}

	@RequestMapping("/getall")
	public ModelAndView getall(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView mv = new ModelAndView();
		List<Vaccinationcenter> list=service.getall();
		mv.setViewName("vaccinationcentre.jsp");
		mv.addObject("list",list);
		return mv;
	}


	@RequestMapping("/deleteVC")
	public ModelAndView delete(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView mv = new ModelAndView();

		int id = Integer.parseInt(request.getParameter("id"));
		boolean status =service.deletebyid(id);
		mv.setViewName("dashboard.jsp");

		return mv;
	}

	@RequestMapping("/edit")
	public ModelAndView editrecord(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView mv = new ModelAndView();

		Vaccinationcenter vc = new Vaccinationcenter();
		//int id = Integer.parseInt(request.getParameter("id"));
		vc.setVaccinationCenterId(Integer.parseInt(request.getParameter("id")));
		vc.setVaccinationCenterName(request.getParameter("centername"));
		vc.setVaccinationCenterCity(request.getParameter("centercity"));
		if(service.edit(vc)!=null) 
		{
			mv.setViewName("display.jsp");
		}
		return mv;
	}

	@RequestMapping("/view")
	public ModelAndView viewMethod(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView mv = new ModelAndView();

		int id = Integer.parseInt(request.getParameter("id"));

		Optional<Vaccinationcenter> vc = service.findbyID(id);
		if(vc.isPresent()) 
		{
			Vaccinationcenter centre = vc.get();

			mv.setViewName("viewVC.jsp");
			mv.addObject("center",centre);

			
			List<Citizen> citizens = cservice.getCitizensByVaccinationcenter(centre);
			mv.addObject("citizens", citizens);

			//
		} else {
			
			mv.setViewName("error.jsp");
		}
	return mv;
}

}

