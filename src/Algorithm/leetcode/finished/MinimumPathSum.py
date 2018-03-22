# Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
#
# Note: You can only move either down or right at any point in time.
#
# Example 1:
# [[1,3,1],
#  [1,5,1],
#  [4,2,1]]
# Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.

class Solution(object):
    # beat 55%
    def minPathSum(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        cost=[]
        rowL=len(grid)
        colL=len(grid[0])
        tempCost=0
        for i in range(0,rowL):
            tempCost=tempCost+grid[i][0]
            L=[tempCost]
            cost.append(L)

        tempCost=cost[0][0]
        for i in range(1, colL):
            tempCost=tempCost+grid[0][i]
            cost[0].append(tempCost)

        for i in range(1, rowL):
            L=cost[i]
            for j in range(1, colL):
                L.append(min(cost[i][j-1], cost[i-1][j])+grid[i][j])
        print(cost)
        return cost[-1][-1]

    def minPathSum1(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        costRow=[]
        costCol=[]
        rowL=len(grid)
        colL=len(grid[0])
        tempCost=0
        for i in range(0,rowL):
            tempCost=tempCost+grid[i][0]
            costRow.append(tempCost)

        tempCost=0
        for i in range(0, colL):
            tempCost=tempCost+grid[0][i]
            costCol.append(tempCost)

        for i in range(1,rowL):
            
            for j in range(j, colL):
                pass

grid=[[1,3,1],
 [1,5,1],
 [4,2,1]]
sol=Solution()
print(sol.minPathSum(grid))

