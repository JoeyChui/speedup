package me.joeychui.speedup;

import me.joeychui.speedup.leetcode.ValidParentheses;
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