package com.sh.start.BankMembers;

import java.util.List;

public interface MembersDAO {
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception;
	
	public List<BankMembersDTO> getSearchByID(String search)throws Exception;
	
	//bankMembers 회원가입
	public int setJoin(BankMembersDTO bankMembersDTO)throws Exception;

}
