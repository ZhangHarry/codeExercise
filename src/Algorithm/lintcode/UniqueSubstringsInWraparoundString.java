package Algorithm.lintcode;


/**
 * Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".

 Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.

 Example
 Example 1:

 Input: "a"
 Output: 1
 Explanation: Only the substring "a" of string "a" is in the string s.


 Example 2:

 Input: "cac"
 Output: 2
 Explanation: There are two substrings "a", "c" of string "cac" in the string s.


 Example 3:

 Input: "zab"
 Output: 6
 Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.
 */
public class UniqueSubstringsInWraparoundString {
	/**
	 * 思路：确定末尾是某个char的最长有多少，然后把所有长度加起来就是了。确定末尾比确定开头更高效，因为我们每次得到的是末尾，不需要维护开头。
	 * 注意：1、保存长度的方式优于直接保存字符串！！！2、唯一确定字符串的是长度加上头/尾，尾比头更好。
	 *
	 * beat 10%
	 * @param p: the given string	 *
	 * @return: the number of different non-empty substrings of p in the string s
	 */
	public int findSubstringInWraproundString(String p) {
		// Write your code here
		int maxL = p.length();
		if (maxL<=1)
			return maxL;
		int j=1;
		int[] lengthArray = new int[26];
		int length = 1;
		char pre = p.charAt(0);
		char cur = p.charAt(1);
		lengthArray[pre-'a']=1;
		int result = 1;
		while (j<maxL){
			cur = p.charAt(j);
			if (cur-pre==1 || cur-pre==-25){
				length++;
			}else {
				length=1;
			}
			int tmp = lengthArray[cur-'a'];
			lengthArray[cur-'a']=Math.max(length, tmp);
			result += lengthArray[cur-'a']-tmp;
			j++;
			pre = cur;
		}
		return result;
	}

	// beat 6%
	public int findSubstringInWraproundString0(String p) {
		// Write your code here
		if (p.length()<=1)
			return p.length();
		int j=1;
		int[] lengthArray = new int[26];
		int length = 1;
		lengthArray[p.charAt(0)-'a']=1;
		while (j<p.length()){
			char pre = p.charAt(j-1), cur = p.charAt(j);
			if (cur-pre==1 || cur-pre==-25){
				length++;
			}else {
				length=1;
			}
			lengthArray[cur-'a']=Math.max(length, lengthArray[cur-'a']);
			j++;
		}
		int result = 0;
		for (int i=0; i<26;i++){
			result +=lengthArray[i];
		}
		return result;
	}

	public static void main(String[] args) {
		UniqueSubstringsInWraparoundString test = new UniqueSubstringsInWraparoundString();
		System.out.println(test.findSubstringInWraproundString("zab"));

	}
}
