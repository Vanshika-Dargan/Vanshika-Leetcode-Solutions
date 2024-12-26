class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        if (Math.abs(target) > sum) {
            return 0;
        }

        int totalRange = (2 * sum) + 1;
        int[][] dp = new int[nums.length][totalRange];

        dp[nums.length - 1][sum + nums[nums.length - 1]]++;
        dp[nums.length - 1][sum - nums[nums.length - 1]]++;


        for (int i = nums.length - 2; i >= 0; i--) {
            for (int curr = 0; curr < totalRange; curr++) {
                if (curr + nums[i] < totalRange) {
                    dp[i][curr] += dp[i + 1][curr + nums[i]];
                }
                if (curr - nums[i] >= 0) {
                    dp[i][curr] += dp[i + 1][curr - nums[i]];
                }
            }
        }

        return dp[0][sum + target];
    }
}
