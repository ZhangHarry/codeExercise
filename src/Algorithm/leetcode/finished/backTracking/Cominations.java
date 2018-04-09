package Algorithm.leetcode.finished.backTracking;
import java.util.*;
/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * @author zhanghr
 *
 */
public class Cominations {
	public List<List<Integer>> combine(int n, int k) {
        List<Integer> solution = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if (k <= 0 || n <= 0 || k > n)
            return result;
        
        List<Integer> candidates = new LinkedList<>();
        for (int i=1;i<=n; i++){
            candidates.add(i);
        }
        backTrack(result, candidates, k, solution);
        return result;
    }
    
	/**
	 * beat 88.06%
	 * @param result
	 * @param candidates
	 * @param k
	 * @param solution
	 */
    public void backTrack(List<List<Integer>> result, List<Integer> candidates, int k, List<Integer> solution){
        // end condition and record
        if (k == 0) {
            List<Integer> list = new LinkedList<>();
            list.addAll(solution);
            result.add(list);
            return;
        }
        if (k == candidates.size()){
            List<Integer> list = new LinkedList<>();
            list.addAll(solution);
            list.addAll(candidates);
            result.add(list);
            return;
        }else if (k > candidates.size()){
            return;
        }
        
        for (int i=0; i<candidates.size(); i++){
            // update state
            Integer integer= candidates.get(i);
            
            List<Integer> ncandidates = new LinkedList<>();
            for (int j = i+1; j<candidates.size(); j++){
                ncandidates.add(candidates.get(j));
            }
            
            solution.add(integer);
            backTrack(result, ncandidates, k-1, solution);   
            solution.remove(solution.size()-1);
             
        }
        
    }
    
}
