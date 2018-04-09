package Algorithm.aimAtOffer;

import java.util.ArrayList;

import util.Printer;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * @author zhanghr
 *
 */
public class ContinousPositiveSeq {
	public static void main(String[] args) {
		ContinousPositiveSeq seq = new ContinousPositiveSeq();
		ArrayList<ArrayList<Integer> > soList = seq.FindContinuousSequence(15);
		System.out.println(soList.size());
		for (ArrayList<Integer> list : soList){
			Printer.print(list);
		}
	}
	
	/**
	 * 先取sum的一半，设为起点和终点，计算总和是否相等，如果小于目的值，则起点减1；如果大于目的值，则终点减1。直至起点<1结束
	 * @param sum
	 * @return
	 */
	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
	       ArrayList<ArrayList<Integer> > solutions = new ArrayList<>();
	        if (sum<=0)
	            return solutions;
	        int start = sum/2, end = start+1;
	        int result = start + end;
	        while(start > 0){
	            if (result == sum) {
	                addElement(solutions, start, end);
	                end = end-1;
	                start = start-1;
	                result -= (end-start+1);
	                System.out.println(String.format("result strat : %d, end : %d", start, end));
	            }else if (result < sum){
	                start = start-1;
	                result += start;
	                System.out.println(String.format("less strat : %d, end : %d", start, end));
	            }else {
	                result -= end;
	                end -= 1;
	                System.out.println(String.format("large strat : %d, end : %d", start, end));
	            }
	        }
	        return solutions;
	    }
	    
	    public void addElement(ArrayList<ArrayList<Integer> > solutions, int start, int end){
	        ArrayList<Integer> list = new ArrayList();
	        for (int i = start;i<=end;i++){
	            list.add(i);
	        }
	        solutions.add(0, list);
	    }
}
