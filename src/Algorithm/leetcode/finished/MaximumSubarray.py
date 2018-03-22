# Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
#
# For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
# the contiguous subarray [4,-1,2,1] has the largest sum = 6.

class Solution(object):
    # beat 57.6%
    #  maxSubArray for A[0:i ] which must has A[i] as the end element
    def maxSubArray1(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        A=[nums[0]]
        for i in range(1, len(nums)):
            if A[i-1] > 0:
                temp=A[i-1]+nums[i]
            else:
                temp=nums[i]
            A.append(temp)
        maxValue=A[0]
        for i in range(1, len(nums)):
            if A[i]>maxValue:
                maxValue=A[i]
        return maxValue

    # beat 51%
    # 将两次循环变成一次循环
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        cur=nums[0]
        maxValue=cur
        for i in range(1, len(nums)):
            temp= cur+nums[i] if cur>0 else nums[i]
            cur=temp
            if cur>maxValue:
                maxValue=cur

        return maxValue

nums=[-2]
sol=Solution()
print(sol.maxSubArray(nums))
nums=[-2,1,-3,4,-1,2,1,-5,4]
print(sol.maxSubArray(nums))
