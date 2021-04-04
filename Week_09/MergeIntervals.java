package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    /*
     * 题 目：合并区间
     * 链 接: https://leetcode-cn.com/problems/merge-intervals/
     * 描 述：以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     *       请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     */
    public int[][] merge(int[][] intervals) {
        int len = 0;
        if (intervals == null || (len = intervals.length) == 0) return new int[0][2];
        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < len; ++i) {
            int left = intervals[i][0], right = intervals[i][1], size = result.size();
            if (size == 0 || left > result.get(size - 1)[1]) {
                result.add(new int[]{left, right});
            } else {
                result.get(size-1)[1]=Math.max(right,result.get(size-1)[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals=new MergeIntervals();
        mergeIntervals.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }
}
