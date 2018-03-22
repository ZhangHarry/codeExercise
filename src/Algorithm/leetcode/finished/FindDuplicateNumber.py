# Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist.
# Assume that there is only one duplicate number, find the duplicate one.
#
# Note:
# You must not modify the array (assume the array is read only).
# You must use only constant, O(1) extra space.
# Your runtime complexity should be less than O(n2).
# There is only one duplicate number in the array, but it could be repeated more than once.

class Solution(object):
    # beat 65%
    # 构造index->array[i]的映射函数，比如对于[1,2,3,5,5,5] 函数f: 0->1, 1->2, 2->3, 3->5, 4->5, 5->5
    # 0-> f(0) -> f(f(0))->...
    # 上例中是0->1->2->3->5->5->-5... 因为array有重复的元素，所以该链有回环，回环开始的地方就是重复的元素
    # 可以构成回环的原因是：array长度是n+1，array元素小于n+1，所以f(e)<=n，因此必然存在f(f(e))，该链长度无限
    # 反证法可以证明回环起始点就是重复的元素
    def findDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        slow=nums[0]
        fast=nums[slow]
        while fast!=slow :
            slow=nums[slow]
            fast=nums[nums[fast]]
        np=0
        while np!=slow:
            np=nums[np]
            slow=nums[slow]

L=[1,2,3,4,3,3]
sol=Solution()
print(sol.findDuplicate(L))
