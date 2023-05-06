package me.joeychui.speedup.speedup;

/**
 * @author cuilihui
 * @date 2019-05-07
 *
 * 38. Count and Say
 */
public class CountAndSay {

    // 组织结构： 顺序 选择 循环 模块化(分段、函数、类) 组合

    // 顺序：最基本 流水线对入参等数据进行加工最后输出结果
    // 选择：两岔口 if else  多岔口 if else if else  选择后一部分 switch
    // 循环：入轨(初始值) 循环 离轨(摘果实) for while
    //
    // 循环控制器：
    //    一定有一个终止条件: 1.循环n次 2.遍历list 3. 循环体中满足了终止条件
    //
    //    通常使用计数器i, 指示器i可同时兼职index取数，指示器有 作用域 的问题
    //    for (int i = 0; i < n; i++) 自带计数器；while()需要前置计数器
    //    for计数器是局部变量 可结合return返回结果；while计数器则是外部变量
    //    所以：
    //    for适合循环体中做操作或者return返回值 while适合中间break或return
    //
    // 循环体：结合if使用 1.选择做什么不做什么 2.选择continue break return

    public String countAndSay(int n) {
        if (n == 1) return "1";
        String last = null;
        StringBuilder current = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            last = current.toString();
            current = new StringBuilder();
            char value = last.charAt(0);
            int count = 1;
            for (int j = 1; j < last.length(); j++) {
                if (last.charAt(j) == value) count++;
                else {
                    current.append(count).append(value);
                    value = last.charAt(j);
                    count = 1;
                }
            }
            current.append(count).append(value);
        }
        return current.toString();
    }

}
