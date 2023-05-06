package me.joeychui.speedup.speedup;

/**
 * @author cuilihui
 * @date 2019-05-03
 *
 * p28. Implement strStr()
 */
public class ImplementStrStr {

    // 字符串匹配问题 可用 双层循环 KMP算法 BM算法
    // 1 显式判断边界情况
    // 2 外层循环记录pos，内层循环累加pos
    // 3 得出 内层循环次数 pos - i == needle.length() 来判断内层循环是否完成
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.length() < needle.length()) return -1;
        int pos = -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                pos = i + 1;
                for (int j = 1; j < needle.length(); j++, pos++) {
                    if (haystack.charAt(pos) != needle.charAt(j)) break;
                }
                if (pos - i == needle.length()) return i;
            }
        }
        return -1;
    }

    // j 设置为外层循环变量 记录内层循环次数
    public int strStr2(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
//        if (haystack.length() < needle.length()) return -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 1;
                while (j < needle.length()) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) break;
                    j++;
                }
                if (j == needle.length()) return i;
            }
        }
        return -1;
    }

    // j++ < needle.length() - 1
    public int strStr3(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 0;
                while (j++ < needle.length() - 1) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) break;
                }
                if (j == needle.length()) return i;
            }
        }
        return -1;
    }

}
