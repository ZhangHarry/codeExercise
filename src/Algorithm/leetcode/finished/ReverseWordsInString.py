# Given an input string, reverse the string word by word.
#
# For example,
# Given s = "the sky is blue",
# return "blue is sky the".

class Solution(object):
    # beat 16%
    def reverseWords1(self, s):
        """
        :type s: str
        :rtype: str
        """
        length=len(s)
        start=-1
        end=0
        isChar=False
        L=[]
        for i in range(0, length):
            if s[i]==" ":
                if isChar:
                    isChar=False
                    end=i
                    L.insert(0, s[start:end])
                    start=-1
            else:
                if not isChar:
                    isChar=True
                    start=i
        if start>-1:
            L.insert(0, s[start:])
        return "_".join(L)

    # beat 13%
    def reverseWords(self, s):
        words=s.split(" ")
        L=[]
        for word in words:
            if len(word) > 0:
                L.insert(0, word)
        return " ".join(L)

sol=Solution()
# s="the sky is blue"
# print(sol.reverseWords(s))
s="the sky is blue "
print(sol.reverseWords(s))
s=" sky is blue"
print(sol.reverseWords(s))
s=" blue "
print(sol.reverseWords(s))
s="1  2"
print(sol.reverseWords(s))
