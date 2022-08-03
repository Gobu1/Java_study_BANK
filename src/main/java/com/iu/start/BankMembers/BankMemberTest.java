package com.iu.start.BankMembers;

import java.util.ArrayList;

public class BankMemberTest {

	public static void main(String[] args) {
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		BankMemberView bankMemberView = new BankMemberView();
		bankMembersDTO.setUSERNAME("ID2");
		bankMembersDTO.setPASSWORD("PW2");
		bankMembersDTO.setNAME("PER2");
		bankMembersDTO.setEMAIL("NAVER");
		bankMembersDTO.setPHONE("2222");
//			bankMemberView.view(bankMembersDTO);
		ArrayList<BankMembersDTO> ar = new ArrayList();
		String search = "PER";
		
		try {
//			int result=bankMembersDAO.setJoin(bankMembersDTO);
//			System.out.println(result==1);
			ar = bankMembersDAO.getSerachByID(search);
			bankMemberView.view(ar);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
