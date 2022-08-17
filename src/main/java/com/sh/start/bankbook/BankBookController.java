package com.sh.start.bankbook;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping(value="/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	@Autowired
	private BankBookService bankBookService;
	
	@RequestMapping(value = "delete.sh", method = RequestMethod.POST)
	public ModelAndView delete(BankBookDTO bankBookDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(bankBookDTO.getBookNum());
		int result = bankBookDAO.delete(bankBookDTO);
		mv.setViewName("redirect:./list.sh");
		if (result>0) {
			System.out.println("삭제 성공");
		}else {
			System.out.println("삭제 실패");
		}
		return mv;
	}
	
	@RequestMapping(value = "delete.sh", method = RequestMethod.GET)
	public ModelAndView delete() throws Exception{
		System.out.println("get. 삭제 실행");
		ArrayList<BankBookDTO> ar = bankBookDAO.getList();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./delete.sh");
		mv.addObject("delete", ar);
			
		return mv; 
	}
	
	@RequestMapping(value = "update.sh", method = RequestMethod.POST)
	public ModelAndView update(BankBookDTO bankBookDTO) throws Exception{
		System.out.println("post. update 실행");
		ModelAndView mv = new ModelAndView();
		int result = bankBookDAO.setUpdate(bankBookDTO);
		System.out.println(result);
		if (result	>0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
//		mv.setViewName("redirect:./list");
		mv.setViewName("redirect:./detail.sh?bookNum="+bankBookDTO.getBookNum());
//		ArrayList<BankBookDTO> ar = new ArrayList();
//		ar = bankBookDAO.getList();
//		mv.addObject("list",ar);
		return mv;
	}
	
	
	@RequestMapping(value = "update.sh", method = RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model) throws Exception{
		System.out.println("get. update 실행");
		System.out.println(bankBookDTO.getBookNum());
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		model.addAttribute("update",bankBookDTO);
	}
	
	
	@RequestMapping(value = "add.sh", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView();
		System.out.println("add GET 실행");
		mv.setViewName("bankbook/add");
		return mv;
	}
	
	@RequestMapping(value = "add.sh", method = RequestMethod.POST)
	public String add(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("add Post 실행");
		int result = bankBookDAO.setBankBook(bankBookDTO);
		if (result==1) {
			System.out.println("정상 add");
		}else {
			System.out.println("작동하지않음");
		}
		
		return "bankbook/add";
	}
	
	@RequestMapping(value = "list.sh", method = RequestMethod.POST)
	public ModelAndView list(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("리스트검색");
		ModelAndView mv = new ModelAndView();
		bankBookDAO.getDetail(bankBookDTO);
		mv.addObject("detail",bankBookDTO);
		mv.setViewName("bankbook/detail");
		return mv;
	}
	
	@RequestMapping(value = "list.sh", method = RequestMethod.GET)
	public String list(HttpServletRequest request) throws Exception {
		System.out.println("리스트 목록");
		ArrayList<BankBookDTO> ar = bankBookDAO.getList();
		request.setAttribute("list", ar);
		
		
		return "bankbook/list";
	}
	
	
		
	@RequestMapping(value = "detail.sh", method = RequestMethod.POST)
	public String detail() {
		System.out.println("post 자세히");
		return "bankbook/detail";
	}
	@RequestMapping(value = "detail.sh", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("get 자세히");
		ModelAndView mv = new ModelAndView();
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		mv.setViewName("bankbook/detail");
		mv.addObject("detail",bankBookDTO);
		return mv;
	}
}
