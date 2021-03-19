package dp;

public class LongestValidParentheses {
    /*
     * 题 目：最长有效括号
     * 链 接: https://leetcode-cn.com/problems/number-of-islands/
     * 描 述：给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *        岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     *        此外，你可以假设该网格的四条边均被水包围。
     */
    //时间复杂度O(n)空间复杂度O(n)
    public int longestValidParentheses(String s) {
        int len = 0;
        if (s == null || (len = s.length()) < 2) return 0;
        int sum = 0;
        int[] dp = new int[len];
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == ')') {
                if (i >= 1 && s.charAt(i - 1) == '(') {
                    dp[i] = (i > 2 ? dp[i - 2] + 2 : 2);
                } else if (i >= 1 && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 > 0 ? dp[i - dp[i - 1] - 2] : 0);
                }
                sum = Math.max(sum, dp[i]);
            }
        }
        return sum;
    }
}
