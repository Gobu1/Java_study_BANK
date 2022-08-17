package com.sh.start.BankMembers;

import java.util.ArrayList;
import java.util.List;

public interface MembersDAO {
	public List<BankMembersDTO> getSearchByID(String search)throws Exception;
	
	//bankMembers 회원가입
	public int setJoin(BankMembersDTO bankMembersDTO)throws Exception;

}
