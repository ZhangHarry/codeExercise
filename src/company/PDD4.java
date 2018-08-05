package company; /**
 * Created by zhanghr on 2018/7/22.
 */
import java.util.*;
public class PDD4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] inputs = s.split(" ");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        String phone = in.nextLine();
        int[] phoneNums = new int[N];
        int[] digits = new int[10];
        for(int i = 0; i < N; i++){
            phoneNums[i] = phone.charAt(i)-'0';
            digits[phoneNums[i]]++;
        }

        //返回target 和 min，只有用到这两个
        int bestNumber = 0;
        int cost = Integer.MAX_VALUE;
        for(int i = 0; i < 10; i++){
            int rest = K-digits[i];
            int curCost = 0;
            int step = 1;
            while(rest>0){
                if(rest>0 && i+step<10){
                    int tmp =0;
                    if (rest>digits[i+step])
                        tmp = digits[i+step];
                    else
                        tmp = rest;
                    curCost = curCost + step*tmp;
                    rest-=tmp;
                }
                if(rest>0 && i-step>=0){
                    int tmp = 0;
                    if (rest>digits[i-step])
                        tmp = digits[i-step];
                    else
                        tmp = rest;
                    curCost = curCost + step*tmp;
                    rest-=tmp;
                }
                step++;
            }
            if(cost>curCost){
                cost = curCost;
                bestNumber = i;
            }
        }

        int[] change = new int[10];
        set(change, K, digits, bestNumber);

        int[] result = new int[N];
        boolean[] visited = new boolean[N];
        for(int i = 0; i < N; i++){
            if(phoneNums[i]>bestNumber && change[phoneNums[i]]>0){
                result[i] = bestNumber;
                change[phoneNums[i]]--;
                visited[i] = true;
            }
        }
        for(int i = N-1; i >=0; i--){
            if(phoneNums[i]<bestNumber && change[phoneNums[i]]>0){
                result[i] = bestNumber;
                change[phoneNums[i]]--;
                visited[i] = true;
            }
        }
        for(int i = 0; i < N; i++){
            if(!visited[i])
                result[i] = phoneNums[i];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(result[i]);
        }
        System.out.println(cost);
        System.out.println(sb.toString());
    }

    private static void set(int[] toChange, int K, int[] nums, int target) {
        int rest = K-nums[target];
        int next = 1;
        while(rest>0){
            if(rest>0 && target+next<10){
                int temp = rest>nums[target+next]?nums[target+next]:rest;
                toChange[target+next] = temp;
                rest-=temp;
            }
            if(rest>0 && target-next>=0){
                int temp = rest>nums[target-next]?nums[target-next]:rest;
                toChange[target-next] = temp;
                rest-=temp;
            }
            next++;
        }
    }
}
