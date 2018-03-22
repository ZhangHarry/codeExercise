# You are climbing a stair case. It takes n steps to reach to the top.
#
# Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
#
# Note: Given n will be a positive integer.

# Example 1:
#
# Input: 2
# Output:  2
# Explanation:  There are two ways to climb to the top.
#
# 1. 1 step + 1 step
# 2. 2 steps
# Example 2:
#
# Input: 3
# Output:  3
# Explanation:  There are three ways to climb to the top.
#
# 1. 1 step + 1 step + 1 step
# 2. 1 step + 2 steps
# 3. 2 steps + 1 step

class Solution(object):
    # beat 78%
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        dp=[]
        dp.append(1)
        dp.append(2)
        for i in range(2,n):
            dp.append(dp[i-1]+dp[i-2])
        return dp[n-1]

sol=Solution()
n=1
print(sol.climbStairs(n))
n=3
print(sol.climbStairs(n))
