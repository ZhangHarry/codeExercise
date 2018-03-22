package Algorithm.leetcode.unfinished;

import java.util.List;

import Algorithm.leetcode.util.Printer;

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
 * prices = [1, 2, 3, 0, 2] maxProfit = 3 transactions = [buy, sell, cooldown,
 * buy, sell]
 * 
 * @author zhanghr
 *
 */

public class P309_1 {

	public int maxProfit(int[] prices) {
		Printer.print(prices);
		Pair pair = getPair(prices);
		int profile = 0;
		Pair curOperation = pair, nextOperation = pair.next;
		while (nextOperation != null && nextOperation.buyDay >= 0) {
			if (curOperation.sellDay < nextOperation.buyDay-1 ) { // 间隔太长
				profile += prices[curOperation.sellDay] - prices[curOperation.buyDay];
				curOperation = nextOperation;
				nextOperation = curOperation.next;
			}else {
				if (prices[curOperation.sellDay] >= prices[nextOperation.buyDay+1] 
						&& prices[curOperation.sellDay-1] >= prices[nextOperation.buyDay]) {

					if (prices[curOperation.sellDay] - prices[curOperation.sellDay-1] > prices[nextOperation.buyDay+1] - prices[nextOperation.buyDay]) {
						nextOperation.buyDay++;
					}else {
						curOperation.sellDay--;
					}
					
				}else if (prices[curOperation.sellDay] > prices[nextOperation.buyDay+1] 
						&& prices[curOperation.sellDay-1] < prices[nextOperation.buyDay]) {
					nextOperation.buyDay++;
				}else if (prices[curOperation.sellDay] <= prices[nextOperation.buyDay+1] 
						&& prices[curOperation.sellDay-1] > prices[nextOperation.buyDay]) {
					curOperation.sellDay--;
				}else {
					curOperation.sellDay = nextOperation.sellDay;
					curOperation.next = nextOperation.next;
					nextOperation = curOperation.next;
				}
			}
		}
		if (curOperation.buyDay >=0)
			profile += prices[curOperation.sellDay] - prices[curOperation.buyDay];
		return profile;
	}

	private Pair getPair(int[] prices) {
		Pair root = new Pair();
		Pair cur = root;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i-1]) {
				if (cur.buyDay < 0) {
					cur.buyDay = i-1;
				}
				cur.sellDay = i;
			}else if (cur.buyDay >= 0){
				Pair next = new Pair();
				cur.sellDay = i-1;
				cur.next = next;
				cur = next;
			}
		}
		root.print();
		return root;
	}

	public void test0() {
		P309_1 p = new P309_1();
		int[] prices = new int[] {};
		int result = p.maxProfit(prices), predict = 0;
		System.out.println((result == predict) + String.format(" %d, %d", result, predict));
		Printer.print(prices);
	}

	public void test1() {
		P309_1 p = new P309_1();
		int[] prices = new int[] { 1, 2, 3, 0, 2 };
		int result = p.maxProfit(prices), predict = 3;
		System.out.println((result == predict) + String.format(" %d, %d", result, predict));
		Printer.print(prices);
	}

	public void test2() {
		P309_1 p = new P309_1();
		int[] prices = new int[] { 3, 2, 1 };
		int result = p.maxProfit(prices), predict = 0;
		System.out.println((result == predict) + String.format(" %d, %d", result, predict));
		Printer.print(prices);
	}

	public void test3() {
		P309_1 p = new P309_1();
		int[] prices = new int[] { 6, 1, 3, 2, 4, 7 };
		int result = p.maxProfit(prices), predict = 6;
		System.out.println((result == predict) + String.format(" %d, %d", result, predict));
		Printer.print(prices);
	}

	public void test4() {
		P309_1 p = new P309_1();
		int[] prices = new int[] { 1, 4, 2 };
		int result = p.maxProfit(prices), predict = 3;
		System.out.println((result == predict) + String.format(" %d, %d", result, predict));
		Printer.print(prices);
	}

	public void test5() {
		P309_1 p = new P309_1();
		int[] prices = new int[] { 2,6,8,7,8,7,9,4,1,2,4,5,8 };
		int result = p.maxProfit(prices), predict = 15;
		System.out.println((result == predict) + String.format(" %d, %d", result, predict));
		Printer.print(prices);
	}

	class Pair {
		int buyDay = -1, sellDay;
		Pair next;
		
		void print(){
			System.out.println(toString());
		}
		@Override
		public String toString(){
			StringBuilder sBuilder = new StringBuilder();
			Pair cur = this;
			while(cur != null){
				sBuilder.append("["+cur.buyDay+","+cur.sellDay+"] ");
				cur = cur.next;
			}
			return sBuilder.toString();
		}
	}

}
