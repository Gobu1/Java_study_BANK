package com.sh.start.homework;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/board/*")
public class HomeWorkController {
	
	private HomeWorkDAO homeWorkDAO;
	
	public HomeWorkController(){
		this.homeWorkDAO = new HomeWorkDAO();
	}
	
	@RequestMapping(value="list.sh", method = RequestMethod.GET)
	public String list() {
		System.out.println("get list 실행");
		
		
		return "redirect:../";
	}
	
	@RequestMapping(value="detail.sh", method = RequestMethod.GET)
	public void detail() {
		
	}
	
	@RequestMapping(value="add.sh", method = RequestMethod.GET)
	public void add() {
		
	}
	
	@RequestMapping(value="add.sh", method = RequestMethod.POST)
	public void add(HomeWorkDTO homeWorkDTO) {
		
	}
	
	@RequestMapping(value="update.sh", method = RequestMethod.GET)
	public void update() {
		
	}
	
	@RequestMapping(value="update.sh", method = RequestMethod.POST)
	public void update(HomeWorkDTO homeWorkDTO) {
		
	}
	
	@RequestMapping(value="delete.sh", method = RequestMethod.GET)
	public void delete() {
		
	}
	

}
