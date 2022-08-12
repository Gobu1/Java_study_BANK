package com.sh.start.bankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;


import com.sh.start.utill.DBConnector;

public class BankAccountDAO implements AccountDAO {

	
	public int setAccount(BankAccountDTO bankAccountDTO) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "INSERT INTO BANKACCOUNT VALUES"
				+ "(ACCOUNT_SEQ	.NEXTVAL,?,?,sysdate)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, bankAccountDTO.getUserName());
		st.setLong(2, bankAccountDTO.getBookNum());
		
	

		int result = st.executeUpdate();
		
		return result;
		

	}

}
