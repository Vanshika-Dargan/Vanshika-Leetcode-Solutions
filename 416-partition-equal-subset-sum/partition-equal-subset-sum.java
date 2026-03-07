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
        boolean prev[] = new boolean[target + 1];

        prev[0] = true;
        if (nums[0] <= target)
            prev[nums[0]] = true;

        for (int i = 1; i < n; i++) {
            boolean curr[] = new boolean[target + 1];
            curr[0] = true;
            for (int j = 1; j <= target; j++) {
                boolean take = false;
                boolean not_take = prev[j];
                if (j - nums[i] >= 0)
                    take = prev[j - nums[i]];

                curr[j] = take || not_take;
            }
            prev = curr;
        }
        return prev[target];
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