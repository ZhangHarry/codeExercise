# Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
#
# Example:
# Given nums = [-2, 0, 3, -5, 2, -1]
#
# sumRange(0, 2) -> 1
# sumRange(2, 5) -> -1
# sumRange(0, 5) -> -3
# Note:
# You may assume that the array does not change.
# There are many calls to sumRange function.

class NumArray(object):

# beat 31%
    def __init__(self, nums):
        """
        :type nums: List[int]
        """
        if len(nums)==0:
            self.dp=[]
            return
        self.dp=[nums[0]]
        for i in range(1, len(nums)):
            self.dp.append(self.dp[-1]+nums[i])

    def sumRange(self, i, j):
        """
        :type i: int
        :type j: int
        :rtype: int
        """
        if len(self.dp)==0:
            return None
        if i==0:
            return self.dp[j]
        return self.dp[j]-self.dp[i-1]



# Your NumArray object will be instantiated and called as such:
# nums=[-2, 0, 3, -5, 2, -1]
# obj = NumArray(nums)
# print(obj.sumRange(0,2))
# print(obj.sumRange(2,5))
# print(obj.sumRange(0,5))

nums=[]
obj = NumArray(nums)
