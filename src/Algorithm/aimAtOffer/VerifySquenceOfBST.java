package Algorithm.aimAtOffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @author zhanghr
 *
 */
public class VerifySquenceOfBST {
	public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0)
            return false;
        return VerifySquenceOfBST(sequence, 0, sequence.length-1);
    }
    
    public boolean VerifySquenceOfBST(int [] sequence, int left, int right) {
        if (left >= right)
            return true;
        int i = left;
        int root = sequence[right];
        while (sequence[i]< root)
            i++;
        for (int j = i; j<right; j++)
            if (sequence[j] < root)
                return false;
        return VerifySquenceOfBST(sequence, left, i-1) && VerifySquenceOfBST(sequence, i, right-1);
    }
}
