package com.sh.start.bankbook;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping(value="/bankbook/*")
public class BankBookController {
	
	
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView();
		System.out.println("add GET 실행");
		mv.setViewName("bankbook/add");
		return mv;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("add Post 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		int result = bankBookDAO.setBankBook(bankBookDTO);
		if (result==1) {
			System.out.println("정상 add");
		}else {
			System.out.println("작동하지않음");
		}
		
		return "bankbook/add";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public ModelAndView list(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("리스트검색");
		BankBookDAO bankBookDAO = new BankBookDAO();
		ModelAndView mv = new ModelAndView();
		bankBookDAO.getDetail(bankBookDTO);
		mv.addObject("detail",bankBookDTO);
		mv.setViewName("bankbook/detail");
		return mv;
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(HttpServletRequest request) throws Exception {
		System.out.println("리스트 목록");
		BankBookDAO bankBookDAO = new BankBookDAO();
		ArrayList<BankBookDTO> ar = bankBookDAO.getList();
		request.setAttribute("list", ar);
		
		
		return "bankbook/list";
	}
	
	
		
	@RequestMapping(value = "detail", method = RequestMethod.POST)
	public String detail() {
		System.out.println("자세히");
		return "bankbook/detail";
	}
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("자세히");
		ModelAndView mv = new ModelAndView();
		BankBookDAO bankBookDAO = new BankBookDAO();
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		mv.setViewName("bankbook/detail");
		mv.addObject("detail",bankBookDTO);
		return mv;
	}
}
