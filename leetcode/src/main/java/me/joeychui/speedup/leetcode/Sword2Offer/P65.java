package me.joeychui.speedup.leetcode.Sword2Offer;

public class P65 {

    public int add(int a, int b) {

        while (b != 0) {
            int carry = (a ^ b) << 1;
            a = a ^ b;
        }

        return -1;

    }


    public static void main(String[] args) {

    }
}
