package me.joeychui.speedup.problem;

import java.util.*;

public class ContainerWithMostWater11 {

    int answer() {
        int[] in = new int[]{4,3,2,1,4};
        return new Solution().maxArea(in);

    }

    class Solution {
        public int maxArea(int[] height) {
            int max = 0;
            for (int i = 0; i < height.length; i++) {
                for (int  j = i + 1; j < height.length; j++) {
                    int temp = (j - i) * Math.min(height[i], height[j]);
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
            return max;
        }
    }
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList();
        Map<Byte, List<String>> number2Letter = new HashMap() {{
            put('2', Arrays.asList("a", "b", "c"));
            put('3', Arrays.asList("d", "e", "f"));
            put('4', Arrays.asList("g", "h", "i"));
            put('5', Arrays.asList("j", "k", "l"));
            put('6', Arrays.asList("m", "o", "n"));
            put('7', Arrays.asList("p", "q", "r", "s"));
            put('8', Arrays.asList("t", "u", "v"));
            put('9', Arrays.asList("w", "x", "y", "z"));
        }
        };
        List<String> out = number2Letter.get(digits.charAt(0));
        for (int i = 1; i < digits.length(); i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < out.size(); j++) {
                String jString = out.get(j);
                for (String z : number2Letter.get(digits.charAt(i))) {
                    String zString = jString+z;
                    temp.add(zString);
                }

            }
            out = temp;
        }
        return out;
    }

    public static int numDecodings(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
    public static void main(String[] args) {
        numDecodings("121");
        letterCombinations("1");
        System.exit(0);

        ContainerWithMostWater11 u1 = null;
        Optional<ContainerWithMostWater11> opt = Optional.of(u1);
        ContainerWithMostWater11 opt1 = Optional.of(u1).orElse(u1);


        ContainerWithMostWater11 containerWithMostWater11 = new ContainerWithMostWater11();
        System.out.println(containerWithMostWater11.answer());
    }
}
