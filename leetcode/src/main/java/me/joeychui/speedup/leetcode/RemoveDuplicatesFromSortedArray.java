package me.joeychui.speedup.leetcode;

/**
 * @author cuilihui
 * @date 2019-05-05
 *
 * p26. Remove Duplicates from Sorted Array
 */
public class RemoveDuplicatesFromSortedArray {

    // My solution is too slow with 85ms.
    // 找出连续重复元素，剩余元素左移，更新length
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length, value = nums[0], count = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] == value) count++;
            else {
                value = nums[i];
                length = cutElements(nums, length, i, count);
                i = i - count;
                count = 0;
            }
        }
        return length - count;
    }

    // 对于 nums[i++] = nums[j++], jvm 先计算i++ 后计算j++
    private int cutElements(int[] nums, int length, int index, int offset) {
        while (index < length)
            nums[index - offset] = nums[index++];
        return length - offset;
    }

    // leetcode题解：快慢指针
    // 快慢指针--应用：
    // 0 有序列表去重
    // 1 寻找有序链表中位数
    // 2 找到链表倒数第K个结点
    // 3 判断单链表是否有环，若有，找到环入口
    // 4 判断两个单链表是否相交，如果相交，找到他们的第一个公共结点
    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            // 条件：快慢之别
            if (nums[j] != nums[i]) {
                i++;
                // action
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
