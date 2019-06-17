package company.wangyi.test;

/**
 * Created by zhanghr on 2018/9/8.
 */
import java.util.*;
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i< T; i++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int L = sc.nextInt();
            int S = sc.nextInt();
            Question[] questions = new Question[N];
            for(int j=0; j<N;j++){
                int X = sc.nextInt();
                questions[j] = new Question(X);
                int tags = sc.nextInt();
                for(int k=0; k<tags; k++) {
                    String tag = sc.next();
                    questions[j].addTag(tag);
                }
            }
            Arrays.sort(questions);
            int res = dfs(questions, 0, M, L, S, new LinkedList<>());
            System.out.println(res);
        }
    }

    private static int dfs(Question[] qs, int index, int count, int L, int S, LinkedList<Question> res){
        if(count + index > qs.length)
            return 0;
        if(count == 0){
            if(res.getLast().level - res.getFirst().level<S)
                return 0;
            int sum = 0;
            Set<String> tags = new HashSet<>();
            for(Question q : res){
                sum += q.level;
                for(String s : q.tags){
                    if(tags.contains(s))
                        return 0;
                    tags.add(s);
                }
            }
            if(sum>L)
                return 0;
            return 1;
        }
        int sum = 0;
        for(int i = index; i<qs.length;i++){
            res.add(qs[i]);
            sum += dfs(qs, index+1, count-1, L, S, res);
            res.removeLast();
        }
        return sum;
    }

}
class Question implements Comparable<Question>{
    int level;
    List<String> tags;
    Question(int level){
        this.level=level;
        this.tags = new ArrayList<>();
    }
    void addTag(String s){
        tags.add(s);
    }
    @Override
    public int compareTo(Question o) {
        return level-o.level;
    }
}
