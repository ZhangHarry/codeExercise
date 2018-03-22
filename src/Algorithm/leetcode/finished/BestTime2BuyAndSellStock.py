class Solution(object):
    # beat 30%
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if (len(prices)<=1):
            return 0
        maxProfile=0
        minPrice=prices[0]
        for i in range(1,len(prices)):
            if minPrice <prices[i]:
                maxProfile=max(prices[i]-minPrice, maxProfile)
            if minPrice > prices[i]:
                minPrice=prices[i]
        return maxProfile
