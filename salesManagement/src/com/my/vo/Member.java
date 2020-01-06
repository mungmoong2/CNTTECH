package com.my.vo;

public class Member {

//	 `member_id` varchar(10) NOT NULL,
//	  `member_name` varchar(10) NOT NULL,

	private String member_id;
	private String member_name;

	public Member() {
		super();
	}

	public Member(String member_id, String member_name) {
		super();
		this.member_id = member_id;
		this.member_name = member_name;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

}
