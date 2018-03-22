# Say you have an array for which the ith element is the price of a given stock on day i.
#
# Design an algorithm to find the maximum profit.
# You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
#
# You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
# After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

# 假设从0…i-1天已经是买卖完成（正好把买来的卖完，从0一开始也是这样）或者是已买入，等待卖出，考虑的是第i天的状态：
# 1、第i天是coolDown状态，那么前一天只能是sell、coolDown、buy
#
# 2、第i天是sell状态，那么前一天只能是buy、coolDown
# 这里注意前一天如果是coolDown状态，那么说明再往前一定有最后一次buy状态，还未来得及卖出，正好在第i天卖出。
#
# 3、第i天是buy状态，那么前一天只能是coolDown
# 所以我们用三个数组来计算最大利润：
#
# coolDown[i]：第i天是coolDown状态时的最大利润，
# sell[i]：第i天是sell状态时的最大利润，
# buy[i]：第i天是buy状态时的最大利润，

# 1、coolDown[i] = max(sell[i - 1]，coolDown[i - 1], buy[i - 1]);
# 2、sell[i] = max (buy[i-1] + price[i] - price[i-1], price[i] + max{buy[某一天x]-prices[x], x<i-1});
# 3、buy[i] = coolDown[i - 1];

# 值得注意的地方的是 sell[i-1] = max{buy[某一天x] - prices[x] + prices[i-1], x<i-1}
# sell[i] = max (collDown[i-2] + prices[i] - prices[i-1],  prices[i] + sell[i-1]-prices[i-1])
# coolDown[i] = max(sell[i - 1]，coolDown[i - 1], coolDown[i - 2]);

class Solution(object):
    # beat 60%
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices)<2:
            return 0
        elif len(prices)==2:
            return max(prices[1]-prices[0],0)
        coolDown=[]
        sell=[]
        for i in range(0,len(prices)):
            coolDown.append(0)
            sell.append(0)
        sell[1]=prices[1]-prices[0]

        for i in range(2, len(prices)):
            sell[i]=max(coolDown[i-2] + prices[i] - prices[i-1], prices[i] + sell[i-1]-prices[i-1])
            coolDown[i]=max(sell[i - 1], coolDown[i - 1], coolDown[i - 2])

        return max(sell[-1], coolDown[-1])


    def maxProfit1(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices)<2:
            return 0
        elif len(prices)==2:
            return max(prices[1]-prices[0],0)
        coolDown=[]
        sell=[]
        tsCD=[]
        tsSell=[]
        for i in range(0,len(prices)):
            coolDown.append(0)
            sell.append(0)
        sell[1]=prices[1]-prices[0]
        tsCD.append(["cooldown"])
        tsCD.append(["cooldown"])
        tsSell.append([])
        tsSell.append(["buy", "sell"])

        for i in range(2, len(prices)):
            u1=coolDown[i-2] + prices[i] - prices[i-1] # i-1 buy, i sell
            u2=prices[i] + sell[i-1]-prices[i-1] # i-1 cooldown, i sell
            if u1 > u2:
                sell[i]=u1
                L=[]
                L.extend(tsCD[i-2])
                L.append("buy")
                L.append("sell")
                tsSell.append(L)
            else:
                sell[i]=u2
                L=[]
                L.extend(tsCD[i-1])
                L.append("sell")
                tsSell.append(L)
            u1=sell[i - 1] # i-1 sell, i cooldown
            u2=coolDown[i - 1] # i-1,i cooldown
            u3=coolDown[i - 2] # i-1 buy,i cooldown
            maxU=max(u1, u2, u3)
            coolDown[i]=maxU
            if maxU==u1:
                L=[]
                L.extend(tsSell[i-1])
                L.append("coolDown")
                tsCD.append(L)
            elif maxU==u2:
                L=[]
                L.extend(tsCD[i-1])
                L.append("coolDown")
                tsCD.append(L)
            else:
                L=[]
                L.extend(tsCD[i-2])
                L.append("sell")
                L.append("coolDown")
                tsCD.append(L)
        if sell[-1] > coolDown[-1]:
            return tsSell[-1]
        else:
            return tsCD[-1]

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = ["buy", "sell", "cooldown", "buy", "sell"]
sol=Solution()
print(sol.maxProfit(prices))
