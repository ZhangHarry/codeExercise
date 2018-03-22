# Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
#
# For example, given the following triangle
# [
#      [2],
#     [3,4],
#    [6,5,7],
#   [4,1,8,3]
# ]
# The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
#
# Note:
# Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

class Solution(object):
    # beat 97.46%
    def minimumTotal1(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        if len(triangle)==0:
            return None
        L=[]
        rowLength=len(triangle)
        for i in range(0,rowLength):
            L.append(0)
        L[0]=triangle[0][0]
        for i in range(1,rowLength):
            # 从末端往前赋值，避免新值把旧值覆盖。
            # 注意L[j]=min(L[j],L[j-1])这个地方L[j]被更新，如果是从1往后更新，L[j+1]=min(L[j+1],L[j])这个地方使用的L[j]不对
            L[i]=L[i-1]+triangle[i][i]
            for j in range(i-1,0,-1):
                L[j]=min(L[j],L[j-1])+triangle[i][j]
            L[0]=L[0]+triangle[i][0]

        # find min value
        minValue=L[0]
        for i in range(1,rowLength):
            if minValue>L[i]:
                minValue=L[i]
        return minValue

    # beat 51%
    def minimumTotal(self, triangle):
        if len(triangle)==0:
            return None
        L1=[]
        L=[]
        rowLength=len(triangle)
        L1.append(triangle[0][0])
        for i in range(1,rowLength):
            L.append(L1[0]+triangle[i][0])
            for j in range(1,i):
                L.append(min(L1[j],L1[j-1])+triangle[i][j])
            L.append(L1[-1]+triangle[i][i])
            L1=[]
            L1.extend(L)
            L=[]

        minValue=L1[0]
        for i in range(1,rowLength):
            if minValue>L1[i]:
                minValue=L1[i]
        return minValue

from util.utils import Printer
sol=Solution()
tringle=[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
print(sol.minimumTotal1(tringle))
tringle=[[-7],[-2,1],[-5,-5,9],[-4,-5,4,4],[-6,-6,2,-1,-5],[3,7,8,-3,7,-9],[-9,-1,-9,6,9,0,7],[-7,0,-6,-8,7,1,-4,9],[-3,2,-6,-9,-7,-6,-9,4,0],[-8,-6,-3,-9,-2,-6,7,-5,0,7],[-9,-1,-2,4,-2,4,4,-1,2,-5,5],[1,1,-6,1,-2,-4,4,-2,6,-6,0,6],[-3,-3,-6,-2,-6,-2,7,-9,-5,-7,-5,5,1]]
printer=Printer()
printer.printListList(tringle)
print(sol.minimumTotal1(tringle), -63)
