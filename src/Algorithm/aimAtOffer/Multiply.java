package Algorithm.aimAtOffer;

public class Multiply {
	public int[] multiply(int[] A) {
        int length = A.length;
        int[] left = new int[length], right = new int[length];
        left[0]=A[0];
        right[length-1]=A[length-1];
        for (int i=1;i<length-1;i++){
            left[i] = left[i-1]*A[i];
            right[length-i-1] = right[length-i] * A[length-i-1];
        }
        int[] result = new int[length];
        result[0] = right[1];        
        result[length-1] = left[length-2];
        for (int i=1;i<length-1;i++){
            result[i] = left[i-1] * right[i+1];
        }
        return result;
    }
	
	public static void main(String[] args) {
		Multiply test = new Multiply();
		int[] array = new int[]{1,2,3,4,5};
		test.multiply(array);		
	}
}
