package com.my.vo;

import java.sql.Timestamp;

public class JanEarnings {

//	`member_id` varchar(10) NOT NULL,
//	  `sales_date` date NOT NULL,
//	  `sales_code` int(11) NOT NULL,
//	  `sales_count` int(11) NOT NULL,

	private Member member;
	private String member_id;
	private Timestamp sales_date;
	private SalesType salestype;
	private int sales_count;
	private int count;

	public JanEarnings() {
		super();
	}

	public JanEarnings(Member member, String member_id, Timestamp sales_date, SalesType salestype, int sales_count,
			int count) {
		super();
		this.member = member;
		this.member_id = member_id;
		this.sales_date = sales_date;
		this.salestype = salestype;
		this.sales_count = sales_count;
		this.count = count;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public Timestamp getSales_date() {
		return sales_date;
	}

	public void setSales_date(Timestamp sales_date) {
		this.sales_date = sales_date;
	}

	public SalesType getSalestype() {
		return salestype;
	}

	public void setSalestype(SalesType salestype) {
		this.salestype = salestype;
	}

	public int getSales_count() {
		return sales_count;
	}

	public void setSales_count(int sales_count) {
		this.sales_count = sales_count;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
