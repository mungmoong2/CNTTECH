package com.my.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.my.vo.Coin;

@Service
public class CoinService {
	public List<List<Coin>> changeList(Coin coin, int price) {
		Collections.sort(coin.getList());
		List<List<Coin>> results = solutions(coin.getList(), new int[coin.getList().size()], price, 0);
		return results;
	}

	public static List<List<Coin>> solutions(List<Coin> coins, int[] variation, int price, int position) {
		List<List<Coin>> list = new ArrayList<>();
		int value = compute(coins, variation);
		if (value < price) {
			for (int i = position; i < coins.size(); i++) {
				if (coins.get(i).getCount() > variation[i]) {
					int[] newvariation = variation.clone();
					newvariation[i]++;
					List<List<Coin>> newList = solutions(coins, newvariation, price, i);
					if (newList != null) {
						list.addAll(newList);
					}
				}
			}
		} else if (value == price) {
			list.add(printList(variation, coins));
		}
		return list;
	}

	public static int compute(List<Coin> coins, int[] variation) {
		int ret = 0;
		for (int i = 0; i < variation.length; i++) {
			ret += coins.get(i).getValue() * variation[i];
		}
		return ret;
	}

	public static List<Coin> printList(int[] ar, List<Coin> coins) {
		List<Coin> tmp = new ArrayList<>();
		Coin tmpCoin = null;
		for (int i = 0; i < ar.length; i++) {
			tmpCoin = new Coin();
			int v = coins.get(i).getValue();
			int c = ar[i];

			if (c != 0) {

				tmpCoin.setValue(v);
				tmpCoin.setCount(c);
				tmp.add(tmpCoin);
			}
		}
		return tmp;
	}

}
