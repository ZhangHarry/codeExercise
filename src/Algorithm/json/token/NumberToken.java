package Algorithm.json.token;

/**
 * Created by zhanghr on 2016/12/4.
 */
public class NumberToken extends VarToken {
    public NumberToken(String label) {
        this.symbol = '\0';
        this.label = label;
        this.nextTokens.add(CommaToken.class);
    }
}
