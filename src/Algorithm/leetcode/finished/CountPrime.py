class Solution:
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        count=0
        prime=[]
        for x in range(0,n):
            prime.append(True)
        for x in range(2,n):
            if(prime[x]):
                for y in range(2,n):
                    temp=x*y
                    if temp>=n:
                        break
                    prime[temp]=False
        count=0
        l=[]
        for x in prime[2:n]:
            if x==True:
                count=count+1
        return count