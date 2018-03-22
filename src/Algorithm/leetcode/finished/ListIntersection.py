# Notes:
# If the two linked lists have no intersection at all, return null.
# The linked lists must retain their original structure after the function returns.
# You may assume there are no cycles anywhere in the entire linked structure.
# Your code should preferably run in O(n) time and use only O(1) memory.

# Definition for singly-linked list.
class ListNode(object):
     def __init__(self, x):
         self.val = x
         self.next = None

class Solution(object):
    def getIntersectionNode(self, headA, headB):
        """
        :type head1, head1: ListNode
        :rtype: ListNode
        """
        pA,pB = headA,headB
        la=self.len(pA)
        lb=self.len(pB)
        pA,pB = headA,headB
        if la>lb:
            pA=self.skip(pA, la-lb)
            print("pA",pA.val)
        elif lb>la:
            pB=self.skip(pB, lb-la)
            print("pB",pB.val)
        while True :
            if pA==pB:
                return pA
            if pA==None or pB==None:
                return None
            pA=pA.next
            pB=pB.next


    def len(self, node):
        count=0
        while not node==None:
            count=count+1
            node=node.next
        return count

    def skip(self, node, times):
        count=0
        while count<times:
            node=node.next
            count=count+1
        return node

n1=ListNode(2)
n2=ListNode(3)
n1.next=n2
sol=Solution()
print(sol.getIntersectionNode(n1,n2).val)
