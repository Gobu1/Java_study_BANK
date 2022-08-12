package com.sh.start.BankMembers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sh.start.utill.DBConnector;

public class BankMembersDAO implements MembersDAO {
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		
		Connection con = DBConnector.getConnection();
		
		String sql ="SELECT USERNAME, NAME FROM BANKMEMBER WHERE USERNAME = ? AND "
				+ "PASSWORD = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, bankMembersDTO.getUserName());
		st.setString(2, bankMembersDTO.getPassWord());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUserName(rs.getString("USERNAME"));
			bankMembersDTO.setName(rs.getString("NAME"));
		}else {
			bankMembersDTO=null;
		}
		
		return bankMembersDTO;
		
	}
	
	//검색어를 입력해서 ID를 찾기
	@Override
	public ArrayList<BankMembersDTO> getSerachByID(String search) throws Exception {
		ArrayList<BankMembersDTO> ar = new ArrayList<BankMembersDTO>();
		
		Connection con = DBConnector.getConnection();
		
		String sql ="SELECT * FROM BANKMEMBER WHERE USERNAME LIKE ? ";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, "%"+search+"%");
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next())
		{
			BankMembersDTO bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUserName(rs.getString("USERNAME"));
			bankMembersDTO.setPassWord(rs.getString("PASSWORD"));
			bankMembersDTO.setName(rs.getString("NAME"));
			bankMembersDTO.setEmail(rs.getString("EMAIL"));
			bankMembersDTO.setName(rs.getString("PHONE"));
			ar.add(bankMembersDTO);

		}
		
		return ar;
	}
	
	
	
	
	@Override
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		
		Connection con = DBConnector.getConnection();
		
		String sql = "INSERT INTO BANKMEMBER "
				+ "(USERNAME,PASSWORD,NAME,EMAIL,PHONE) "
				+ "VALUES(?,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		
		
		st.setString(1, bankMembersDTO.getUserName());
		st.setString(2, bankMembersDTO.getPassWord());
		st.setString(3, bankMembersDTO.getName());
		st.setString(4, bankMembersDTO.getEmail());
		st.setString(5, bankMembersDTO.getName());
		

		int result = st.executeUpdate();

//		ResultSet rs = st.executeQuery();
//		while(rs.next())
//		{
//			bankMembersDTO.setUSERNAME(rs.getString(1));
//			bankMembersDTO.setPASSWORD(rs.getString(2));
//			bankMembersDTO.setNAME(rs.getString(3));
//			bankMembersDTO.setEMAIL(rs.getString(4));
//			bankMembersDTO.setPHONE(rs.getString(5));
//		}
		
		
		return result;
	}

	
	
	
}
