package com.my.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dao.SalesDAO;
import com.my.exception.NotFoundException;
import com.my.vo.JanEarnings;
import com.my.vo.Search;

@Service
public class SalesService {
	@Autowired
	private SalesDAO dao;

	public List<JanEarnings> Detail(Search search) {
		List<JanEarnings> list = new ArrayList<>();
		try {
			list = dao.selectDetailList(search);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<JanEarnings> Count(Search search) {
		List<JanEarnings> list = new ArrayList<>();
		try {
			list = dao.selectCountList(search);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public List<JanEarnings> Monthly(Search search) {
		List<JanEarnings> list = new ArrayList<>();
		try {
			list = dao.selectMonthlyCount(search);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

}
