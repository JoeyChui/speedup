package me.joeychui.speedup;

import me.joeychui.speedup.leetcode.SearchInsertPosition;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author cuilihui
 * @date 2019-05-04
 */
class SearchInsertPositionTest {

    @Test
    void searchInsert() {
        SearchInsertPosition s = new SearchInsertPosition();
        assertTrue(s.searchInsert(new int[] {1,3,5,6}, 0) == 0);
        assertTrue(s.searchInsert(new int[] {1,3}, 2) == 1);
    }
}