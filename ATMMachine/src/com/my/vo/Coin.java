package com.my.vo;

import java.util.List;

public class Coin implements Comparable<Coin> {

	private int value;
	private int count;
	private List<Coin> list;

	public Coin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coin(int value, int count) {
		super();
		this.value = value;
		this.count = count;

	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Coin> getList() {
		return list;
	}

	public void setList(List<Coin> list) {
		this.list = list;
	}

	@Override
	public int compareTo(Coin target) {
		if (this.getValue() < target.getValue())
			return 1;
		else if (this.getValue() > target.getValue())
			return -1;
		return 0;
	}

}
