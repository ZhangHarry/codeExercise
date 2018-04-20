package Algorithm.aimAtOffer;

public class UglyNumber {
	public int GetUglyNumber_Solution(int index) {
        if(index<=6)
            return index;
        int[] array = new int[index];
        int index1 = 0, index2 = 0, index3 = 0;
        int n = 1;
        array[0] = 1;
        while (n < index){
            int t1 = array[index1] * 2;
            int t2 = array[index2] * 3;
            int t3 = array[index3] * 5;
            int min = Math.min (Math.min(t1, t2), t3);
            array[n] = min;
            n++;
            if (min == t1)
                index1++;
            if (min == t2)
                index2++;
            if (min == t3) 
                index3++;
        }
        return array[index-1];
    }
	
	public static void main(String[] args) {
		UglyNumber test = new UglyNumber();
		System.out.println(test.GetUglyNumber_Solution(7));
	}
}
