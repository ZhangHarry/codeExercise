package Algorithm.json;

import Algorithm.json.token.NumberToken;
import Algorithm.json.token.QuoteToken;
import Algorithm.json.token.StringToken;
import Algorithm.json.token.Token;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanghr on 2016/12/4.
 */
public class TokenAnalyser {
    int position;
    Byte currByte;
    byte[] input;
    List<Token> tokens ;

    public TokenAnalyser(byte[] input) {
        init(input);
    }

    public List<Token> tokenAnalyse() throws WrongFormatException, InstantiationException, IllegalAccessException {
        try {
            while (hasNext()) {
                skipSpace();
                Token token = readNextToken();
                if (token != null)
                    tokens.add(token);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            throw new WrongFormatException("incomplete json string");
        }
        return tokens;
    }

    private void init(byte[] input) throws NullPointerException{
        if (input == null)
            throw new NullPointerException("bytes is null");
        this.input = input;
        this.tokens = new ArrayList<>();
        this.position = 0;
        this.currByte = input[position];
    }


    private void skipSpace() {
        while (hasNext() && (( currByte = input[position]).compareTo(Constant.SPACE1) == 0 || currByte.compareTo(Constant.SPACE2) == 0
                || currByte.compareTo(Constant.SPACE3) == 0|| currByte.compareTo(Constant.RT) == 0) ) {
            position++;
        }
    }

    private boolean hasNext() {
        return position < input.length;
    }


    public Token readNextToken() throws WrongFormatException, IllegalAccessException, InstantiationException {
        skipSpace();
        Token token = Constant.map.get(currByte);
        if (token == null){
            if (isStringHeader(currByte)) {
                token = readStringToken();
            }else if (isDigit(currByte)){
                token= readNumberToken();
            }else
                throw new WrongFormatException(String.format("unexpected character : %s", currByte));
        }else if (token instanceof QuoteToken){
            token = readQuoteToken();
        }else {
            token = readSymbolToken(token);
        }
        return token;
    }

    private Token readSymbolToken(Token token) throws IllegalAccessException, InstantiationException {
        Token t = token.getClass().newInstance();
        t.setPosition(position);
        position++;
        return t;
    }

    private Token readQuoteToken() throws WrongFormatException {
        int start = position+1;//因为input[position]是"，不需要保留
        do{
            position++;
        }while (hasNext() && ((currByte = input[position]) - Constant.QUOTE != 0));
        int end = position;
        if (currByte - Constant.QUOTE == 0) {
            Token token = new StringToken(new String(input, start, end - start));
            token.setPosition(start);
            position++;
            return token;
        }else
            throw new WrongFormatException(String.format("lack of %s at %d", Constant.QUOTE, position-1));
    }

    private Token readNumberToken() {
        int start = position;
        do{
            position++;
        }while (hasNext() && (isNumber((currByte = input[position]))));
        int end = position;
        Token token = new NumberToken(new String(input, start, end-start));
        token.setPosition(start);
        return token;
    }

    /**
     * 这里的String指的是一般编程语言里有效的变量名，即以字母、美元符号或下划线开头，后面跟字母、下划线、数字、美元符号
     * 与quote不同，quote内容可以是任何字符
     * @return
     */
    private Token readStringToken() {
        int start = position;
        do{
            position++;
        } while (hasNext() && isString((currByte = input[position])));
        int end = position;
        Token token = new StringToken(new String(input, start, end-start));
        token.setPosition(start);
        return token;
    }

    private boolean isNumber(Byte currByte) {
        if (isDigit(currByte) || currByte-(byte)('.')==0)
            return true;
        return false;
    }

    private boolean isString(Byte currByte) {
        return isStringHeader(currByte) || isDigit(currByte);
    }

    private boolean isDigit(Byte currByte) {
        if ( (currByte.compareTo((byte)('0')) >=0 && currByte.compareTo((byte)('9')) <=0 ))
            return true;
        return false;
    }

    private boolean isStringHeader(Byte currByte) {
        if ( (currByte.compareTo((byte)'a') >=0 && currByte.compareTo((byte)('z')) <=0 ) ||
                (currByte.compareTo((byte)('A')) >=0 && currByte.compareTo((byte)('Z')) <=0 ) ||
                (currByte.compareTo((byte)('_'))) == 0 ||(currByte.compareTo((byte)('$'))) == 0)
            return true;
        return false;
    }

}
