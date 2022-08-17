package com.sh.start.BankMembers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired 
	private BankMembersDAO bankMembersDAO;
	@Autowired
	private BankMembersService bankMembersService;
	
	@RequestMapping(value = "logout.sh", method = RequestMethod.GET)
	public String logout(HttpSession session)throws Exception{
		System.out.println("GET 로그아웃");
		session.invalidate();
		return "redirect:../";
	}
	
	
	// annotation
	// @ : 설명+실행
	@RequestMapping(value = "search.sh", method = RequestMethod.GET)
	public String getSearchByID() throws Exception {
		System.out.println("서치 실행");
		return "member/search";
	}
	
	@RequestMapping(value = "search.sh", method = RequestMethod.POST)
	public String getSearchByID(BankMembersDTO bankMembersDTO, Model model) throws Exception {
		System.out.println("post 서치 실행");
		
		System.out.println(bankMembersDTO.getUserName());
		List<BankMembersDTO> ar = bankMembersDAO.getSearchByID(bankMembersDTO.getUserName());
		
		model.addAttribute("list", ar);
		return "member/list";
	}
	
	// /member/login 
	@RequestMapping(value = "login.sh", method = RequestMethod.GET)
	public String login() {
		System.out.println("로그인 실행");
		return "member/login";
		
	}
	
	@RequestMapping(value = "login.sh", method = RequestMethod.POST)
	public String login(HttpServletRequest request,BankMembersDTO bankMembersDTO) throws Exception {
		System.out.println("DB 로그인 실행");
		bankMembersDTO = bankMembersDAO.getLogin(bankMembersDTO);
		System.out.println(bankMembersDTO.getUserName());
//		model.addAttribute("member",bankMembersDTO);
		HttpSession session = request.getSession();
		session.setAttribute("member", bankMembersDTO);
		// "redirect: 다시 접속할 url주소(절대경로,상대경로)"
		return "redirect:../";
		
	}
	
	// join /member/join
	@RequestMapping(value = "join.sh", method = RequestMethod.GET)
	public String join() {
		
		System.out.println("join GET 실행");
		return "member/join";
	}
	
	// Post 
	@RequestMapping(value = "join.sh", method = RequestMethod.POST)
	public String join(HttpServletRequest request, String username) throws Exception {
		System.out.println("join POST 실행");
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName(username);
		bankMembersDTO.setPassWord(request.getParameter("password"));
		bankMembersDTO.setName(request.getParameter("name"));
		bankMembersDTO.setEmail(request.getParameter("email"));
		bankMembersDTO.setPhone(request.getParameter("phone"));
		int s = bankMembersDAO.setJoin(bankMembersDTO);
		if (s==1) {
			System.out.println("정상 join");
		}else {
			System.out.println("작동하지않음");
		}
//		
		return "redirect:./login.sh";
	}

}
