package com.example.demo.controller;

import com.example.demo.pojo.Admin;
import com.example.demo.service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController 
{
	@Autowired
	AdminService service;

	@RequestMapping("/")
	public ModelAndView defaultPage(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView mv=new ModelAndView();

		mv.setViewName("login.jsp");

		return mv;
	}

	@RequestMapping("/registration")
	public ModelAndView insertrecord(HttpServletRequest request,HttpServletResponse response) 
	{
		ModelAndView mv=new ModelAndView();

		Admin a = new Admin();
		a.setPassword(request.getParameter("password"));
		a.setEmail(request.getParameter("email"));
		a.setUsername(request.getParameter("username"));

		if(service.insert(a)!=null) 
		{
			mv.setViewName("login.jsp");
		}

		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) 
	{
		ModelAndView mv = new ModelAndView();
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Admin isAuthenticated = service.findByUsernameAndPassword(username, password); 

		if (isAuthenticated != null) 
		{
			mv.setViewName("dashboard.jsp");
		} 
		else 
		{
			mv.setViewName("error.jsp");
		}
		return mv;
	}

}
