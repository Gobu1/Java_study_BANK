package com.iu.start.BankMembers;

import java.util.ArrayList;

public class BankMemberView {
	
	public void view(BankMembersDTO bankMembersDTO)
	{
		System.out.println(bankMembersDTO.getUSERNAME());
		System.out.println(bankMembersDTO.getPASSWORD());
		
		
	}
	public void view(ArrayList<BankMembersDTO> ar)
	{
		for (BankMembersDTO bankMembersDTO : ar)
		{
			System.out.println(bankMembersDTO.getUSERNAME());
			System.out.println(bankMembersDTO.getPASSWORD());
			System.out.println(bankMembersDTO.getNAME());
			System.out.println(bankMembersDTO.getEMAIL());
			System.out.println(bankMembersDTO.getPHONE());
		}
	}

}
