# Say you have an array for which the ith element is the price of a given stock on day i.
# Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
# However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

class Solution(object):
    # beat 57%
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if (len(prices)<=1):
            return 0
        maxProfile=0
        minPrice=prices[0]
        maxPrice=minPrice
        for i in range(1,len(prices)):
            if prices[i]>=prices[i-1]:
                maxPrice=prices[i]
            else:
                maxProfile = maxProfile+maxPrice-minPrice
                minPrice=prices[i]
                maxPrice=minPrice
            if prices[i]<minPrice:
                minPrice=prices[i]
                maxPrice=minPrice

        return maxProfile+maxPrice-minPrice

L=[1,2,1,3,5]
sol=Solution()
print(sol.maxProfit(L))
