# You are a professional robber planning to rob houses along a street.
# Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
# and it will automatically contact the police if two adjacent houses were broken into on the same night.
#
# Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

class Solution(object):
    # beat 47%
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums)==0:
            return 0
        elif len(nums)==1:
            return nums[0]
        steal=[]
        for i in range(0,len(nums)):
            steal.append(0)
        steal[0]=nums[0]
        steal[1]=max(nums[1], nums[0])
        for i in range(2,len(nums)):
            steal[i]=max(steal[i-2]+nums[i], steal[i-1])

        return steal[-1]
