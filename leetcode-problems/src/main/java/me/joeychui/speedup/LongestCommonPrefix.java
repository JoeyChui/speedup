package me.joeychui.speedup;

/**
 * @author: cuilihui
 * @date: 2019-05-01
 *
 * p14. Longest Common Prefix
 */
public class LongestCommonPrefix {

    // 1 入参判空 默认值是""
    // 2 返回值用result 不改变入参的值
    // 3 s.substring(i, j) 返回第 i ~ j-1 位的字符串
    // 4 注意默认值 逻辑上初始值 pos = length
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            result = getCommonPrefix(result, strs[i]);
        }
        return result;
    }

    private String getCommonPrefix(String s1, String s2) {
        int length = s1.length() < s2.length() ? s1.length() : s2.length(), pos = length;
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                pos = i;
                break;
            }
        }
        return s1.substring(0, pos);
    }

    // 题解
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

}
