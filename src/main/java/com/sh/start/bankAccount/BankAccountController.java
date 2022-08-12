package com.sh.start.bankAccount;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sh.start.BankMembers.BankMembersDTO;

@Controller
@RequestMapping(value="/bankAccount/*")
public class BankAccountController {
	private BankAccountDAO bankAccountDAO;
	
	public BankAccountController(){
		this.bankAccountDAO = new BankAccountDAO();
	}
	
	@RequestMapping(value = "add.sh", method = RequestMethod.GET)
	public String jadd(BankAccountDTO bankAccountDTO, HttpSession session)throws Exception {
		System.out.println("get. 계좌 add");
		System.out.println(bankAccountDTO.getBookNum());
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		bankAccountDTO.setUserName(bankMembersDTO.getUserName());
		
		int result = this.bankAccountDAO.setAccount(bankAccountDTO);
		
		return "redirect:../bankbook/list.sh";
	}

}
