package com.sh.start.BankMembers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller 
//이 클래스는 Controller역할, 
//Container에게 이 클래스의 객체를 생성을 위임 *container-생명주기를 관리하는 역할
@RequestMapping(value="/member/*")
public class MemberController {
	
	// annotation
	// @ : 설명+실행
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String getSearchByID() throws Exception {
		System.out.println("서치 실행");
		return "member/search";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public String getSearchByID(BankMembersDTO bankMembersDTO, Model model) throws Exception {
		System.out.println("post 서치 실행");
		
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		ArrayList<BankMembersDTO> ar = bankMembersDAO.getSerachByID(bankMembersDTO.getUsername());
		
		model.addAttribute("list", ar);
		return "member/list";
	}
	
	// /member/login 
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		System.out.println("로그인 실행");
		return "member/login";
		
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(BankMembersDTO bankMembersDTO) {
		System.out.println("DB 로그인 실행");
		// "redirect: 다시 접속할 url주소(절대경로,상대경로)"
		return "redirect:../";
		
	}
	
	// join /member/join
	@RequestMapping(value = "join")
	public String join() {
		
		System.out.println("join GET 실행");
		return "member/join";
	}
	
	// Post 
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO /*HttpServletRequest request, String username*/) throws Exception {
		System.out.println("join POST 실행");
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		bankMembersDTO.setUSERNAME(username);
//		bankMembersDTO.setPASSWORD(request.getParameter("password"));
//		bankMembersDTO.setNAME(request.getParameter("name"));
//		bankMembersDTO.setEMAIL(request.getParameter("email"));
//		bankMembersDTO.setPHONE(request.getParameter("phone"));
//		int s = bankMembersDAO.setJoin(bankMembersDTO);
//		if (s==1) {
//			System.out.println("정상 join");
//		}else {
//			System.out.println("작동하지않음");
//		}
//		
		return "redirect:./login";
	}

}
