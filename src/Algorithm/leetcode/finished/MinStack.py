class MinStack:
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.L=[]
        self.minL=[]

    def push(self, x):
        """
        :type x: int
        :rtype: void
        """
        self.L.append(x)
        if len(self.minL)==0:
            self.minL.append(x)
        elif self.minL[-1]>=x:
            self.minL.append(x)

    def pop(self):
        """
        :rtype: void
        """
        x=self.L.pop()
        if self.minL[-1]==x:
            self.minL.pop()

    def top(self):
        """
        :rtype: int
        """
        return self.L[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.minL[-1]


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
