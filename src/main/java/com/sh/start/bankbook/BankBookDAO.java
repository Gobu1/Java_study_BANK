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
		st.setString(2, bankBookDTO.getBookName());
		st.setDouble(3, bankBookDTO.getBookRate());
		st.setInt(4, bankBookDTO.getBookSale());
		
		

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
			bankBookDTO.setBookNum(rs.getLong("BOOKNUM"));
			bankBookDTO.setBookName(rs.getString("BOOKNAME"));
			bankBookDTO.setBookRate(rs.getDouble("BOOKRATE"));
			bankBookDTO.setBookSale(rs.getInt("BOOKSALE"));
			ar.add(bankBookDTO);
		}
		
		
		return ar;
	}
	
	

	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "UPDATE BANKBOOK SET BOOKSALE = ? WHERE BOOKRATE = ? ";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1,bankBookDTO.getBookSale());
		st.setDouble(2, bankBookDTO.getBookRate());
		
		int result = st.executeUpdate();
		
		return result;
	}

	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUM = ? ";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		
		
		st.setLong(1, bankBookDTO.getBookNum());
		
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			bankBookDTO.setBookNum(rs.getLong("BOOKNUM"));
			bankBookDTO.setBookName(rs.getString("BOOKNAME"));
			bankBookDTO.setBookRate(rs.getDouble("BOOKRATE"));
			bankBookDTO.setBookSale(rs.getInt("BOOKSALE"));
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

	@Override
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "UPDATE BANKBOOK SET BOOKNAME=?, "
				+ "BOOKRATE=? WHERE BOOKNUM=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,bankBookDTO.getBookName());
		st.setDouble(2, bankBookDTO.getBookRate());
		st.setLong(3, bankBookDTO.getBookNum());
		
		int result = st.executeUpdate();
		
		return result;
		
	}

	@Override
	public int delete(BankBookDTO bankBookDTO) throws Exception {

		Connection con = DBConnector.getConnection();
		
		String sql = "DELETE FROM BANKBOOK WHERE BOOKNUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1,bankBookDTO.getBookNum());
		
		
		int result = st.executeUpdate();
		
		return result;
	}

}
