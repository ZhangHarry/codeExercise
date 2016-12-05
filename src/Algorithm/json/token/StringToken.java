package Algorithm.json.token;

/**
 * Created by zhanghr on 2016/12/3.
 */
public class StringToken extends VarToken {
    public StringToken(String label) {
        this.symbol = (byte)label.charAt(0);
        this.label = label;
        this.nextTokens.add(ColonToken.class);
        this.nextTokens.add(CommaToken.class);
    }

}
