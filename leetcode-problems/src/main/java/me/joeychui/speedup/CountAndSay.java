package me.joeychui.speedup;

/**
 * @author cuilihui
 * @date 2019-05-07
 *
 * 38. Count and Say
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String last = "";
        StringBuilder current = new StringBuilder("1");
        int value, count;
        for (int i = 1; i < n; i++) {
            last = current.toString();
            current = current.delete(0, current.length());
            value = last.charAt(0);
            count = 1;
            for (int j = 1; j < last.length(); j++) {
                if (last.charAt(j) == value) {
                    count += 1;
                } else {
                    current.append(count).append((char) value);
                    value = last.charAt(j);
                    count = 1;
                }
            }
            current.append(count).append((char) value);
        }
        return current.toString();
    }
}
