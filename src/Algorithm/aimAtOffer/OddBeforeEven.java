package Algorithm.aimAtOffer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author zhanghr
 *
 */
public class OddBeforeEven {
	// in-place解法，从后往前扫描，将后面的连续奇数段和前面的连续偶数段交换位置
    public void reOrderArray(int [] array) {
        int index = array.length-1;
        while (index >=0){
            if (array[index] % 2 == 0){
                index--;
            }else{
                int e = index;
                int s2 = e;
                while (s2>=0 && array[s2]%2 == 1){
                    s2--;
                }
                if (s2 == -1)
                    break;
                else{
                    int s1 = s2;
                    s2++;
                    while (s1>=0 && array[s1]%2 == 0)
                        s1--;
                    s1++;
                    swap(array, s1, s2, e);
                    index = s1+e-s2;
                }
            }
        }
    }
    
    // [s1, s2-1]这段是偶数，[s2, e]这段是奇数，将两段数据互换位置但不改变相对位置。
    public void swap(int[] array, int s1, int s2, int e){
        swap(array, s1, e);
        swap(array, s1, s1+e-s2);
        swap(array, s1+e-s2+1, e);
        System.out.println(Arrays.toString(array));
    }
    
    public void swap(int[] array, int s, int e){
          for (int i=s, j=e; i<j; i++,j--){
              int tmp = array[i];
              array[i] = array[j];
              array[j] = tmp;
          }        
    }
}
