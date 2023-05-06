package me.joeychui.speedup.problem;

public class compareVersion {
    /*
    * 经验
    * 1返回值比较长度：String version1 = "1.01", version2 = "1.001";
    * 2返回值比较存不存在
    * */


    static int compare(String version1, String version2) {
        String splitStr = "\\.";
        String[] list1 = version1.split(splitStr);
        String[] list2 = version2.split(splitStr);
        int length = list1.length > list2.length ? list1.length : list2.length;
        for (int i = 0; i < length; i++) {
            int span1 = getVersionInt(list1, i);
            int span2 = getVersionInt(list2, i);
            if (span1 != span2) {
                return span1 - span2 > 0 ? 1:-1;
            }
        }
        return 0;
    }

    static int getVersionInt(String[] list, int index) {
        if (index >= list.length) {
            return 0;
        } else {
            return Integer.valueOf(list[index]);
        }
    }

    public static void main(String[] args) {
        String version1 = "1", version2 = "1.0.0";
        int result = compare(version1, version2);
        System.out.println(result);
    }
}
