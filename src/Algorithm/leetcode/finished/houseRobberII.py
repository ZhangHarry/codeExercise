# After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention.
# This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
# Meanwhile, the security system for these houses remain the same as for those in the previous street.
#
# Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

class Solution(object):
    # beat 67%
    # 设f(0,n)表示偷到第n家，没偷第一家的最大收获；f(1,n)表示偷到第n家，偷了第一家的最大收获
    # f(0,n)=max(f(0,n-1), f(0,n-2)+nums[n])
    # f(1,n)=max(f(1,n-1), f(1,n-2)+nums[n])
    # f(last)=max(f(0,n), f(1,n-1)) 偷到最后一家的最大收获
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length=len(nums)
        if length==0:
            return 0
        elif length==1:
            return nums[0]
        elif length==2:
            return max(nums[0], nums[1])
        pickFirst=[]
        discardFirst=[]
        for i in range(0, length):
            pickFirst.append(0)
            discardFirst.append(0)
        discardFirst[0]=0
        discardFirst[1]=nums[1]
        pickFirst[0]=nums[0]
        pickFirst[1]=nums[0]
        for i in range(2, length):
            pickFirst[i]=max(pickFirst[i-1], pickFirst[i-2]+nums[i])
            discardFirst[i]=max(discardFirst[i-1], discardFirst[i-2]+nums[i])
        return max(pickFirst[-2], discardFirst[-1])
