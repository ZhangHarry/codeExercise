# Given an array of integers, every element appears twice except for one. Find that single one.
#
# Note:
#
# Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

class Solution(object):
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length=len(nums)
        result=nums[0]
        for i in range(1,length):
            result = nums[i] ^ result
        return result

L=[1]
sol=Solution()
print(sol.singleNumber(L))
