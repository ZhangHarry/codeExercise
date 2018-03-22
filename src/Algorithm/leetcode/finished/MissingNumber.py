# Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
#
# Example 1
# Input: [3,0,1]
# Output: 2

class Solution(object):
    # beat 55%
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length=len(nums)
        result=0
        for i in range(1,length+1):
            result = result ^ i
        for num in nums:
            result = result ^ num
        return result

    # beat 47%
    def missingNumber2(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        length=len(nums)
        result=0
        for num in nums:
            result = result + num
        return int(length*(length+1)*0.5-result)

L=[3,0,1]
sol=Solution()
print(sol.missingNumber2(L))
