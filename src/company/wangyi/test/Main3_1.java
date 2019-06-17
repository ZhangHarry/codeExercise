package company.wangyi.test;

/**
 * Created by zhanghr on 2018/9/8.
 */
import java.util.*;
public class Main3_1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int tests = sc.nextInt();
            for(int i = 0; i< tests; i++){
                int N = sc.nextInt();
                int M = sc.nextInt();
                int L = sc.nextInt();
                int S = sc.nextInt();
                Question[] questions = new Question[N];
                for(int j=0; j<N;j++){
                    int X = sc.nextInt();
                    questions[j] = new Question(X);
                    int P = sc.nextInt();
                    for(int k=0; k<P;k++)
                        questions[j].addTag(sc.next());
                }
                Arrays.sort(questions);
                System.out.println(deal(questions, 0, M, L, S, new ArrayList<>(), 0));
            }
        }
        private static int deal(Question[] qs, int start, int count, int L, int S, List<Question> res, int util){
            if(count>qs.length-start) return 0;
            if(start<qs.length && L-util < qs[start].level*count) return 0;
            if(count==0){
                if(res.get(res.size()-1).level-res.get(0).level<S) return 0;
                int sum = 0;
                Set<String> used = new HashSet<>();
                for(Question q : res){
                    sum+=q.level;
                    for(String s : q.tags){
                        if(used.contains(s)) return 0;
                        used.add(s);
                    }
                }
                if(sum>L) return 0;
                return 1;
            }
            int sum = 0;
            for(int i = start; i<qs.length;i++){
                res.add(qs[i]);
                sum += deal(qs, start+1, count-1, L, S, res,util +qs[i].level);
                res.remove(res.size()-1);
            }
            return sum;
        }
    }