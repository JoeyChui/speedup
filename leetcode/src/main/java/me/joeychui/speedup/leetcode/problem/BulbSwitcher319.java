package me.joeychui.problem;

import java.util.HashSet;
import java.util.Set;

public class BulbSwitcher319 {

    private ContainerWithMostWater11 c = new ContainerWithMostWater11();

    public BulbSwitcher319 () {
        System.out.println(c.answer());
    }

    public static void main(String[] args) {
        BulbSwitcher319 b = new BulbSwitcher319();
        System.out.println(b);
    }

    

    int configDivisorNum(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i * i <= n; i++) {
            if (n / i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }
        return set.size();
    }
}
