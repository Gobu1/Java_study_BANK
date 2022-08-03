package com.iu.start.BankMembers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.start.utill.DBConnector;

public class BankMembersDAO implements MembersDAO {
	
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
			bankMembersDTO.setUSERNAME(rs.getString("USERNAME"));
			bankMembersDTO.setPASSWORD(rs.getString("PASSWORD"));
			bankMembersDTO.setNAME(rs.getString("NAME"));
			bankMembersDTO.setEMAIL(rs.getString("EMAIL"));
			bankMembersDTO.setPHONE(rs.getString("PHONE"));
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
		
		
		
		st.setString(1, bankMembersDTO.getNAME());
		st.setString(2, bankMembersDTO.getPASSWORD());
		st.setString(3, bankMembersDTO.getNAME());
		st.setString(4, bankMembersDTO.getEMAIL());
		st.setString(5, bankMembersDTO.getPHONE());
		

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
