package Algorithm.aimAtOffer;

/*
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 */
public class ReverseSentence {
	
	public String reverseSentence(String str) {
        if (str.length() <= 1)
            return str;
        char[] array = str.toCharArray();
        reverse(array, 0, array.length-1);
        int start=0;
        for (int i=0; i<array.length; i++){
            if (array[i]==' '){
                reverse(array, start, i-1);
                start = i+1;
            }
        }
        reverse(array, start, array.length-1);
        return new String(array,0, array.length);
    }
    
    public void reverse(char[] array, int start, int end){
        if (start >= array.length)
            return;
        while(start < end){
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
    	ReverseSentence test = new ReverseSentence();
    	System.out.println(test.reverseSentence("student. a am I"));
	}
}
