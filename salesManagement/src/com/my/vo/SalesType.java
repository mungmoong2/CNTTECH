package com.my.vo;

public class SalesType {

//	 `sales_code` int(11) NOT NULL,
//	  `sales_name` varchar(10) NOT NULL,

	private int sales_code;
	private String sales_name;

	public SalesType() {
		super();
	}

	public SalesType(int sales_code, String sales_name) {
		super();
		this.sales_code = sales_code;
		this.sales_name = sales_name;
	}

	public int getSales_code() {
		return sales_code;
	}

	public void setSales_code(int sales_code) {
		this.sales_code = sales_code;
	}

	public String getSales_name() {
		return sales_name;
	}

	public void setSales_name(String sales_name) {
		this.sales_name = sales_name;
	}

}
