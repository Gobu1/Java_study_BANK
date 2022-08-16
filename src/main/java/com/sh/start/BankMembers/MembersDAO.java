package com.sh.start.BankMembers;

import java.util.ArrayList;

public interface MembersDAO {
	
	public ArrayList<BankMembersDTO> getSerachByID(String search)throws Exception;
	
	//bankMembers 회원가입
	public int setJoin(BankMembersDTO bankMembersDTO)throws Exception;

}
