package me.joeychui.speedup;

/**
 * @author cuilihui
 * @date 2019-05-04
 *
 * p35. Search Insert Position
 */
public class SearchInsertPosition {

    // 如何写出一个正确的二分查找算法：
    // 1 每次循环都要确保缩小范围
    //     high = mid - 1; low = mid + 1;
    // 2 最后一次low和high相遇 最接近target
    //     while(low <= high)
    public int searchInsert(int[] nums, int target) {
        if (nums == null) return -1;

        int low = 0, high = nums.length - 1, mid = 0;
        // 最后一次比较：
        // 进入时候 low == high
        // 进入后   min == low == high
        // 出来时候 要么返回找到的值的索引 要么对面的指针越界
        // *此时，mid 其实是最接近target的（没有更接近的了)*
        while (low <= high) {
            mid = (high + low) / 2;
            // mid 已经比较过了 缩小范围 mid - 1 mid + 1
            if (target == nums[mid])
                return mid;
            else if (target < nums[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        // 返回 mid 或者 mid + 1
        return target < nums[mid] ? mid : mid + 1;
    }

    // 0ms的解法：类似第一匹配的思路
    public int searchInsert2(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid]>= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 二分查找 及其变种
    // https://www.cnblogs.com/luoxn28/p/5767571.html
    // 查找第一个相等的元素
    static int findFirstEqual(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] >= key) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        if (left < array.length && array[left] == key) {
            return left;
        }

        return -1;
    }

    // 查找最后一个相等的元素
    static int findLastEqual(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        // 这里必须是 <=
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] <= key) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        if (right >= 0 && array[right] == key) {
            return right;
        }

        return -1;
    }
}
