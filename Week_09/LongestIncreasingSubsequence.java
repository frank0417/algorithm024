public class LongestIncreasingSubsequence {
    /*
     * 题 目：最长递增子序列
     * 链 接: https://leetcode-cn.com/problems/longest-increasing-subsequence/
     * 描 述：给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     */

    //O(n^2)
    public int lengthOfLIS(int[] nums) {
        int len = nums.length, maxLen = 1;
        int[] dp = new int[len];
        for (int i = 0; i < len; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    //O(nlog(n))
    public int lengthOfLISII(int[] nums) {
        int end=0,len=nums.length;
        int[] dp=new int[len];
        dp[0]=nums[0];
        for(int i=1;i<len;++i){
            if(nums[i]>dp[end]){
                end++;
                dp[end]=nums[i];
            }else{
                int left=0,right=end,mid=0;
                while(left<right){
                    mid=(left+right)/2;
                    if(nums[i]>dp[mid]){
                        left=mid+1;
                    }else{
                        right=mid;
                    }
                }
                dp[left]=nums[i];
            }
        }
        return end+1;
    }
}
