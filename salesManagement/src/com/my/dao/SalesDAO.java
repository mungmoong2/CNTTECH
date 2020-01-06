package com.my.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.exception.NotFoundException;
import com.my.vo.JanEarnings;
import com.my.vo.Search;

@Repository
public class SalesDAO {
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public List<JanEarnings> selectDetailList(Search search) throws NotFoundException {
		List<JanEarnings> list;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		list = sqlSession.selectList("com.my.vo.JanEarnings.selectDetailList", search);
		if (list == null) {
			throw new NotFoundException("목록이 없습니다.");
		}
		return list;
	}

	public List<JanEarnings> selectCountList(Search search) throws NotFoundException {
		List<JanEarnings> list = new ArrayList<>();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		list = sqlSession.selectList("com.my.vo.JanEarnings.selectCountList", search);
		if (list == null) {
			throw new NotFoundException("목록이 없습니다.");
		}
		return list;
	}

	public List selectMonthlyCount(Search search) throws NotFoundException {
		List list = new ArrayList<>();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String createTable = "CREATE TABLE temp_date ( temp_date date NOT NULL, PRIMARY KEY (temp_date))";
		String dropTable = "DROP TABLE temp_date";

		sqlSession.update("com.my.vo.JanEarnings.createTable", createTable);
		sqlSession.insert("com.my.vo.JanEarnings.insertTable", search);
		list = sqlSession.selectList("com.my.vo.JanEarnings.selectMonthlyCount");
		sqlSession.update("com.my.vo.JanEarnings.createTable",dropTable); 

		if (list == null) {
			throw new NotFoundException("목록이 없습니다.");
		}
		return list;
	}

}
