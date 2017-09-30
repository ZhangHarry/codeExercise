package Algorithm.rotateDice;

import java.util.*;

/**
 * Created by Zhanghr on 2016/4/27.
 */
public class TransformDice {
    Dice dice;
    Dictionary<String, String> dictory = new Hashtable<>();
    public TransformDice(Dice dice){
        this.dice = dice;
        this.dice.transList = "init";
    }

    public void rotate(){
        Queue<Dice> queue = new ArrayDeque<>();
        queue.add(this.dice);
        while (!queue.isEmpty()){
            Dice dice = queue.poll();
            if (dictory.get(dice.toString())==null){
                dictory.put(dice.toString(), dice.transList);
                for (Transformation t : dice.transformations()){
                    Dice transformedDice = t.transform(dice);
                    if (dictory.get(transformedDice.toString())==null){
                        queue.add(transformedDice);
                    }
                }
            }
        }
//        System.out.println(dictory);
    }

    public void searchRotateWay(String[] end){
        Dice target = new Dice(end);
        if (this.dictory.size()>0){/* already travel around*/
            String solution = this.dictory.get(target.toString());
            if (solution == null)
                System.out.println("there is no solution");
            else
                System.out.println("solution : "+solution);
            System.exit(0);
        }
        Queue<Dice> queue = new ArrayDeque<>();
        queue.add(this.dice);
        if (dice.toString().equals(target.toString()))
            System.out.println(dice.transList);
        while (!queue.isEmpty()){
            Dice dice = queue.poll();
            if (dictory.get(dice.toString())==null){
                dictory.put(dice.toString(), dice.transList);
                for (Transformation t : dice.transformations()){
                    Dice transformedDice = t.transform(dice);
                    //solution
                    if (transformedDice.toString().equals(target.toString()))
                        System.out.println(transformedDice.transList);
                    if (dictory.get(transformedDice.toString())==null){
                        queue.add(transformedDice);
                    }
                }
            }
        }
//        System.out.println(dictory);
    }

    public static void main(String[] args){
        String[] symbols = new String[]{"r","g","g","g","g","r"};
        String[] target = new String[]{"g","g","r","r","g","g"};
        TransformDice test = new TransformDice(new Dice(symbols));
//        test.rotate();
        test.searchRotateWay(target);
    }
}
