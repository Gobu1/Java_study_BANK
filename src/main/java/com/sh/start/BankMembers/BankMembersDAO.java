package com.sh.start.BankMembers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sh.start.utill.DBConnector;

@Repository
public class BankMembersDAO implements MembersDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.sh.start.BankMembers.BankMembersDAO.";
	
	@Override
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"getLogin", bankMembersDTO);
		
	}
	
	//검색어를 입력해서 ID를 찾기
	@Override
	public List<BankMembersDTO> getSearchByID(String search) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"getSearchByID", search);
	}
	
	
	
	
	@Override
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		
	
		
		return sqlSession.insert(NAMESPACE+"setJoin", bankMembersDTO);
	}

	
	
	
}
