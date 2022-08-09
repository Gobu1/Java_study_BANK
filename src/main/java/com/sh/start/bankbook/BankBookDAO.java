package com.sh.start.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sh.start.utill.DBConnector;

public class BankBookDAO implements BookDAO {

	@Override
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {

		long millis = System.currentTimeMillis();
		Connection con = DBConnector.getConnection();
		
		String sql = "INSERT INTO BANKBOOK "
				+ "VALUES(?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, millis);
		st.setString(2, bankBookDTO.getBookname());
		st.setDouble(3, bankBookDTO.getBookrate());
		st.setInt(4, bankBookDTO.getBooksale());
		
		

		int result = st.executeUpdate();
		
		return result;
	}

	@Override
	public ArrayList<BankBookDTO> getList() throws Exception {
		ArrayList<BankBookDTO> ar = new ArrayList();
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM BANKBOOK ORDER BY BOOKNUM DESC";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while (rs.next())
		{
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBooknum(rs.getLong("BOOKNUM"));
			bankBookDTO.setBookname(rs.getString("BOOKNAME"));
			bankBookDTO.setBookrate(rs.getDouble("BOOKRATE"));
			bankBookDTO.setBooksale(rs.getInt("BOOKSALE"));
			ar.add(bankBookDTO);
		}
		
		
		return ar;
	}

	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "UPDATE BANKBOOK SET BOOKSALE = ? WHERE BOOKRATE = ? ";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1,bankBookDTO.getBooksale());
		st.setDouble(2, bankBookDTO.getBookrate());
		
		int result = st.executeUpdate();
		
		return result;
	}

	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUM = ? ";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		
		
		st.setLong(1, bankBookDTO.getBooknum());
		
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			bankBookDTO.setBooknum(rs.getLong("BOOKNUM"));
			bankBookDTO.setBookname(rs.getString("BOOKNAME"));
			bankBookDTO.setBookrate(rs.getDouble("BOOKRATE"));
			bankBookDTO.setBooksale(rs.getInt("BOOKSALE"));
		}
		
//		if (rs.next())	{
//			while (rs.next()) {
//				bankBookDTO.setBOOKNUM(rs.getLong("BOOKNUM"));
//				bankBookDTO.setBOOKNAME(rs.getString("BOOKNAME"));
//				bankBookDTO.setBOOKRATE(rs.getDouble("BOOKRATE"));
//				bankBookDTO.setBOOKSALE(rs.getInt("BOOKSALE"));
//				}
//			
//			System.out.println(bankBookDTO.getBOOKNUM());
//			System.out.println(bankBookDTO.getBOOKNAME());
//			System.out.println(bankBookDTO.getBOOKRATE());
//			System.out.println(bankBookDTO.getBOOKSALE());
//		}
//		else {
//			return null;
//		}
		
		return bankBookDTO;
	}

}
