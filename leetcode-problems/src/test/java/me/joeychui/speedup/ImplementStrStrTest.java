package me.joeychui.speedup;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: cuilihui
 * @date: 2019-05-03
 */
class ImplementStrStrTest {

    @Test
    void strStr() {
        ImplementStrStr i = new ImplementStrStr();
        assertTrue(i.strStr2("mississippi", "issipi") == -1);
        assertTrue(i.strStr2("hello", "ll") == 2);
    }
}