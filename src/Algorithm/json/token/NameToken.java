package Algorithm.json.token;

/**
 * Created by zhanghr on 2016/12/3.
 */
public class NameToken extends VarToken {
    public NameToken(String label) {
        this.symbol = (byte)label.charAt(0);
        this.label = label;
        this.nextTokens.add(ColonToken.class);
        this.nextTokens.add(CommaToken.class);
    }

}
