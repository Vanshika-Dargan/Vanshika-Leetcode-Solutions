class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int dp[][] = new int[n][2*sum+1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return fn(nums, target, n - 1, dp,sum);
    }

    int fn(int[] nums, int target, int i, int dp[][],int offset) {
        if (i == 0) {
            if (nums[0] == 0 && target == 0) return 2;
            if (target - nums[i] == 0 || target + nums[i] == 0)
                return 1;
            return 0;
        }
        if (target > offset || target < -offset) return 0;
        if (dp[i][target+offset] != -1)
            return dp[i][target+offset];
        int plus = 0;
        int minus = 0;
        plus = fn(nums, target - nums[i], i - 1, dp,offset);
        minus = fn(nums, target + nums[i], i - 1, dp,offset);
        dp[i][target+offset] = plus + minus;
        return dp[i][target+offset];
    }
}