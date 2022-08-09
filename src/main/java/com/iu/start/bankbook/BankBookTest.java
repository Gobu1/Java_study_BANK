package com.iu.start.bankbook;

import java.util.ArrayList;

public class BankBookTest {

	public static void main(String[] args) {
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		BankBookDAO bankBookDAO = new BankBookDAO();
//		BankBookDTO bankBookDTO = new BankBookDTO();
//		bankBookDTO.setBOOKNAME("ZXC");
//		bankBookDTO.setBOOKRATE(14.03);
//		bankBookDTO.setBOOKSALE(0);
		try {
			ar = bankBookDAO.getList();
			for(BankBookDTO bankBookDTO : ar)
			{
				System.out.println(bankBookDTO.getBOOKNUM());
				System.out.println(bankBookDTO.getBOOKNAME());
				System.out.println(bankBookDTO.getBOOKRATE());
				System.out.println(bankBookDTO.getBOOKSALE());
				
			}
//			bankBookDAO.setBankBook(bankBookDTO);
//			bankBookDTO.setBOOKNUM(1659508480295L);
//			bankBookDAO.setChangeSale(bankBookDTO);
//			bankBookDAO.getDetail(bankBookDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
       
		
		
	}

}
