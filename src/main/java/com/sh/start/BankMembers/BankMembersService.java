package com.sh.start.BankMembers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	public List<BankMembersDTO> getSerachByID(String search)throws Exception{
		return bankMembersDAO.getSearchByID(search);
	}
	
	//bankMembers 회원가입
	public int setJoin(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.setJoin(bankMembersDTO);
	}


}
