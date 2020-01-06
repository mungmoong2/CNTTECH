package com.my.vo;

import java.util.List;

public class Machine {
	private List<List<Coin>> coins;
	private int price;

	public Machine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Machine(List<List<Coin>> coins, int price) {
		super();
		this.coins = coins;
		this.price = price;
	}

	public List<List<Coin>> getCoins() {
		return coins;
	}

	public void setCoins(List<List<Coin>> coins) {
		this.coins = coins;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}