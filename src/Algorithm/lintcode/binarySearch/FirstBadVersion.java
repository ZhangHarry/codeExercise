package Algorithm.lintcode.binarySearch;

/**
 *
 * The code base version is an integer start from 1 to n. One day, someone committed a bad version in the code case, so it caused this version and the following versions are all failed in the unit tests. Find the first bad version.

 You can call isBadVersion to help you determine which version is the first bad one. The details interface can be found in the code's annotation part.

 Example
 Given n = 5:

 isBadVersion(3) -> false
 isBadVersion(5) -> true
 isBadVersion(4) -> true
 Here we are 100% sure that the 4th version is the first bad version.

 * Created by zhanghr on 2018/5/31.
 */

public class FirstBadVersion {
    /*
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        if (n < 1)
            return 0;
        if (n <= 2)
            return 1;
        int start = 1, end = n;
        while (true){
            int median = start+(end-start)/2; // 注意这种写法比（start+end）/2好，因为第二种可能溢出
            if (median == start)
                if (SVNRepo.isBadVersion(median))
                    return start;
                else
                    return end;
            boolean tmp = SVNRepo.isBadVersion(median);
            if (tmp)
                end = median;
            else
                start = median;
        }
    }
    public static void main(String[] args){
        SVNRepo.border = 2147483647 ;
        FirstBadVersion test = new FirstBadVersion();
        System.out.println(test.findFirstBadVersion(2147483647 ));
    }

}
class SVNRepo {
    static int border = 10;
     public static boolean isBadVersion(int k){
         return k>= border;
     }
  }