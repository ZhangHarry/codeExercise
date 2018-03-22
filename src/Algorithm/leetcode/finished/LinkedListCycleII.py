# Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
#
# Note: Do not modify the linked list.

class Solution(object):
    # beat 72%
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head==None or head.next==None:
            return None
        fast=head.next.next
        slow=head.next
        while slow!=fast and fast!=None:
            fast=fast.next
            if fast== None:
                return None
            else:
                fast=fast.next
            slow=slow.next
        if fast==None:
            return None
        start=head
        while slow!=start:
            slow=slow.next
            start=start.next
        return slow

from util.ListNode import  ListNode
n1=ListNode(1)
n2=ListNode(2)
n3=ListNode(3)
n1.next=n2
n2.next=n3
sol=Solution()
print(sol.detectCycle(n1))
