package Algorithm.RotateDice;

/**
 * Created by Zhanghr on 2016/4/27.
 */
public class Dice {
    String [] symbol;
    String transList = "";

    public Dice(String[] dice){
        this.symbol = dice;
        assert (this.symbol.length == 6);
    }
    public Transformation[] transformations(){
        return new Transformation[]{new RotateR(), new RotateB()};
    }

    /**
     * 显示骰子
     *     \5\
     *   \_\1\_\_\
     *  _\_\_\_\_\
     * \3\_\2\_\4\_\5\
     *   \_\_\_\_
     *     \6\
     * @return
     */
    public String toString(){
        String[][] chars = new String[6][16];
        for (int i=0;i<chars.length;i++){
            for (int j=0;j<chars[0].length;j+=2){
                chars[i][j] = "|";
                chars[i][j+1] = "_";
            }
        }
        chars[0][5] = symbol[4];//'5';
        chars[1][5] = symbol[0];//'1';
        chars[3][1] = symbol[2];//'3';
        chars[3][5] = symbol[1];//'2';
        chars[3][9] = symbol[3];//'4';
        chars[3][13] = symbol[4];//'5';
        chars[5][5] = symbol[5];//'6';

        StringBuilder s = new StringBuilder();
        for (int i=0;i<chars.length;i++){
            for (int j=0;j<chars[0].length;j++){
                s.append(chars[i][j]);
            }
            s.append("\n");
        }
        return s.toString();
    }

    public String symbols(){
        StringBuilder s = new StringBuilder();
        for (String s1 : symbol){
            s.append(s1+",");
        }
        return s.toString();
    }
}

/**
 * 往右转一下
 */
class RotateR implements Transformation{
    @Override
    public Dice transform(Dice d) {
        String[] newSymbol = new String[d.symbol.length];
        newSymbol[0] = d.symbol[0];
        newSymbol[5] = d.symbol[5];

        newSymbol[2] = d.symbol[4];
        newSymbol[4] = d.symbol[3];
        newSymbol[3] = d.symbol[1];
        newSymbol[1] = d.symbol[2];

        Dice dice = new Dice(newSymbol);
        dice.transList += d.transList +"->rotate right";
        return dice;
    }

    @Override
    public String discription() {
        return "r r";
    }
}

/**
 * 往下转一下
 */
class RotateB implements Transformation{

    @Override
    public Dice transform(Dice d) {
        String[] newSymbol = new String[d.symbol.length];
        newSymbol[2] = d.symbol[2];
        newSymbol[3] = d.symbol[3];

        newSymbol[0] = d.symbol[4];
        newSymbol[4] = d.symbol[5];
        newSymbol[5] = d.symbol[1];
        newSymbol[1] = d.symbol[0];

        Dice dice = new Dice(newSymbol);
        dice.transList += d.transList +"->下转";
        return dice;
    }

    @Override
    public String discription() {
        return "r d";
    }
}
