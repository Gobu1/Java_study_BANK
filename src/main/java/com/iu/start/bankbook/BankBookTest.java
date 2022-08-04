package com.iu.start.bankbook;

public class BankBookTest {

	public static void main(String[] args) {
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO = new BankBookDTO();
//		bankBookDTO.setBOOKNAME("ZXC");
//		bankBookDTO.setBOOKRATE(14.03);
//		bankBookDTO.setBOOKSALE(0);
		try {
//			bankBookDAO.setBankBook(bankBookDTO);
			bankBookDTO.setBOOKNUM(1659508595801L);
//			bankBookDAO.setChangeSale(bankBookDTO);
			bankBookDAO.getDetail(bankBookDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
       
		
		
	}

}
