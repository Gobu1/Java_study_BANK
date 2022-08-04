package com.iu.start.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.start.utill.DBConnector;

public class BankBookDAO implements BookDAO {

	@Override
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {

		long millis = System.currentTimeMillis();
		Connection con = DBConnector.getConnection();
		
		String sql = "INSERT INTO BANKBOOK "
				+ "VALUES(?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, millis);
		st.setString(2, bankBookDTO.getBOOKNAME());
		st.setDouble(3, bankBookDTO.getBOOKRATE());
		st.setInt(4, bankBookDTO.getBOOKSALE());
		
		

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
			bankBookDTO.setBOOKNUM(rs.getLong("BANKNUM"));
			bankBookDTO.setBOOKNAME(rs.getString("BOOKNAME"));
			bankBookDTO.setBOOKRATE(rs.getDouble("BOOKRATE"));
			bankBookDTO.setBOOKSALE(rs.getInt("BOOKSLAE"));
			ar.add(bankBookDTO);
		}
		
		
		return ar;
	}

	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "UPDATE BANKBOOK SET BOOKSALE = ? WHERE BOOKRATE = ? ";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1,bankBookDTO.getBOOKSALE());
		st.setDouble(2, bankBookDTO.getBOOKRATE());
		
		int result = st.executeUpdate();
		
		return result;
	}

	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUM = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, bankBookDTO.getBOOKNUM());
		
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
		bankBookDTO.setBOOKNUM(rs.getLong("BOOKNUM"));
		bankBookDTO.setBOOKNAME(rs.getString("BOOKNAME"));
		bankBookDTO.setBOOKRATE(rs.getDouble("BOOKRATE"));
		bankBookDTO.setBOOKSALE(rs.getInt("BOOKSALE"));
		}
		
		if (rs.next())	{
			
			System.out.println(bankBookDTO.getBOOKNUM());
			System.out.println(bankBookDTO.getBOOKNAME());
			System.out.println(bankBookDTO.getBOOKRATE());
			System.out.println(bankBookDTO.getBOOKSALE());
		}
		else {
			return null;
		}
		
		return bankBookDTO;
	}

}
