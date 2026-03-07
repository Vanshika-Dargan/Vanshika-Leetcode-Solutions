class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;
        boolean dp[][] = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= target)
            dp[0][nums[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                boolean take = false;
                boolean not_take = dp[i - 1][j];
                if (j - nums[i] >= 0)
                    take = dp[i - 1][j - nums[i]];

                dp[i][j] = take || not_take;
            }
        }
        return dp[n - 1][target];
    }

    int fn(int[] nums, int i, int target, int dp[][]) {
        if (target == 0)
            return 1;
        if (i < 0)
            return 0;
        if (dp[i][target] != -1)
            return dp[i][target];
        int take = 0;
        int not_take = fn(nums, i - 1, target, dp);
        if (target - nums[i] >= 0)
            take = fn(nums, i - 1, target - nums[i], dp);
        dp[i][target] = take | not_take;
        return dp[i][target];
    }
}