package me.joeychui.speedup;

import org.junit.jupiter.api.Test;

/**
 * @author cuilihui
 * @date 2019-05-01
 */
class ValidParenthesesTest {

    @Test
    void validParentheses() {
        ValidParentheses v = new ValidParentheses();
        boolean b = v.validParentheses("{}{{[]}()}[{}()]");
    }
}