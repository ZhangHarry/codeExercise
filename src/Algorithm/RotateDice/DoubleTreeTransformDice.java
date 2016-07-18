package Algorithm.RotateDice;

import java.util.ArrayDeque;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Queue;

/**
 * Created by zhanghr on 2016/4/28.
 */
public class DoubleTreeTransformDice {

    Dice strDice, targetDice;
    Dictionary<String, String> strDictory = new Hashtable<>();
    Dictionary<String, String> targetDictory = new Hashtable<>();
    public DoubleTreeTransformDice(Dice dice, Dice target){
        this.strDice = dice;
        this.strDice.transList = "init";
        this.targetDice = target;
        this.targetDice.transList = "end";
    }

    private void rotate(){
        Queue<Dice> strQueue = new ArrayDeque<>();
        Queue<Dice> targetQueue = new ArrayDeque<>();
        strQueue.add(this.strDice);
        targetQueue.add(this.targetDice);
        while (!strQueue.isEmpty()){
            Dice dice = strQueue.poll();
            if (targetDictory.get(dice.toString())!=null){
                break;
            }
            transform(strDictory, dice, strQueue);

            Dice endDice = targetQueue.poll();
            if (strDictory.get(endDice.toString())!=null){
                break;
            }
            transform(targetDictory, endDice, targetQueue);
        }
        System.out.println(strDictory);
    }

    private void transform(Dictionary<String, String> dictionary, Dice dice, Queue<Dice> queue) {
        if (dictionary.get(dice.toString())==null){
            dictionary.put(dice.toString(), dice.transList);
            for (Transformation t : dice.transformations()){
                Dice transformedDice = t.transform(dice);
                if (dictionary.get(transformedDice.toString())==null){
                    queue.add(transformedDice);
                }
            }
        }
    }

    public void searchRotateWay(){
        if (strDice.toString().equals(targetDice.toString()))
            System.out.println(strDice.transList);
        rotate();
        System.out.println(strDictory);
    }

    public static void main(String[] args){
        String[] start = new String[]{"r","g","g","r","g","r"};
        String[] target = new String[]{"g","g","r","r","g","g"};
        DoubleTreeTransformDice test = new DoubleTreeTransformDice(new Dice(start), new Dice(target));
        test.searchRotateWay();
    }
}
