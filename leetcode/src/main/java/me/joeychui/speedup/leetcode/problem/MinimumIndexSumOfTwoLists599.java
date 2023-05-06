package me.joeychui.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumIndexSumOfTwoLists599 {

    private ContainerWithMostWater11 c = new ContainerWithMostWater11();

    public MinimumIndexSumOfTwoLists599() {
        System.out.println(c.answer());
    }

    public static void main(String[] args) {
        MinimumIndexSumOfTwoLists599 b = new MinimumIndexSumOfTwoLists599();
        String[] r = b.findRestaurant(new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[] {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"});
        System.out.println(r.toString());
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        int minSum = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> list2Map = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            list2Map.put(list2[i], i);
        }
        for (int i = 0; i < list1.length; i++) {
            if (list2Map.containsKey(list1[i])) {
                if (i + list2Map.get(list1[i]) < minSum) {
                    minSum = i + list2Map.get(list1[i]);
                    result = new ArrayList<>();
                    result.add(list1[i]);
                } else if (i + list2Map.get(list1[i]) == minSum) {
                    result.add(list1[i]);
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
