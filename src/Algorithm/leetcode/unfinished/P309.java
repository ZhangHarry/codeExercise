package Algorithm.leetcode.unfinished;

import Algorithm.leetcode.util.Tool;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times) with the following restrictions:
 * 
 * You may not engage in multiple transactions at the same time (ie, you must
 * sell the stock before you buy again). After you sell your stock, you cannot
 * buy stock on next day. (ie, cooldown 1 day) Example:
 * 
 * prices = [1, 2, 3, 0, 2] maxProfit = 3 
 * transactions = [buy, sell, cooldown, buy, sell]
 * 
 * @author zhanghr
 *
 */

public class P309 {
	
	int[] store;
	
	public int maxProfit(int[] prices) {
		if (prices.length <= 1) {
			return 0;
		}
		store = new int[prices.length+2];
		int i = 0;
		for (; i < prices.length-1; i++) {
			store[i] = -1;
		}
		store[i] = store[i+1] = store[i+2] = 0;
        return maxProfit(prices, 0, prices.length-1);
    }
	

	public int maxProfit(int[] prices, int start, int end) {
		if (start >= end) {
			return 0;
		}else if (store[start] >= 0) {
			return store[start];
		}
		int buy = start;
		while (buy < end && prices[buy] > prices[buy+1]){
			buy++;
		}
		int sell = buy+1;
		while (sell < end && prices[sell+1] >= prices[sell]){
			sell++;
		}
		if (sell > end) {
			store[start] = 0;
		}else {
			int p1 = prices[sell] - prices[buy] + maxProfit(prices, sell+2, end);
			int p2 = prices[sell-1] - prices[buy] + maxProfit(prices, sell+1, end);
			store[start] = Math.max(p1, p2);
		}
        return store[start];
    }


	public void test0() {
		P309 p = new P309();
		int[] prices = new int[]{};
		int result = p.maxProfit(prices), predict =0;
		System.out.println((result == predict) + String.format(" %d, %d", result, predict) );
		Tool.print(prices);
		Tool.print(p.store);
	}

	public void test1() {
		P309 p = new P309();
		int[] prices = new int[]{1, 2, 3, 0, 2};
		int result = p.maxProfit(prices), predict = 3;
		System.out.println((result == predict) + String.format(" %d, %d", result, predict) );
		Tool.print(prices);
		Tool.print(p.store);
	}

	public void test2() {
		P309 p = new P309();
		int[] prices = new int[]{3, 2, 1};
		int result = p.maxProfit(prices), predict = 0;
		System.out.println((result == predict) + String.format(" %d, %d", result, predict) );
		Tool.print(prices);
		Tool.print(p.store);
	}
	public void test6() {
		P309 p = new P309();
		int[] prices = new int[]{6,1,3,2,4,7};
		int result = p.maxProfit(prices), predict = 6;
		System.out.println((result == predict) + String.format(" %d, %d", result, predict) );
		Tool.print(prices);
		Tool.print(p.store);
	}
}
