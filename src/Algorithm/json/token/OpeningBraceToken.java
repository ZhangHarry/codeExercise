package Algorithm.json.token;

import Algorithm.json.util.Constant;

/**
 * Created by zhanghr on 2016/12/3.
 */
public class OpeningBraceToken extends Token {

    public OpeningBraceToken() {
        this.nextTokens.add(ClosingBraceToken.class);
        this.nextTokens.add(NameToken.class);
        this.symbol = Constant.OPENING_BRACE;
        this.label = new String(new byte[]{symbol});
    }
}
