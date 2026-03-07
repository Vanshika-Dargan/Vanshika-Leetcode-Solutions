class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if(sum%2!=0) return false;
        int target = sum/2;
        int dp[][] = new int[n][target+1];
            for (int row[] : dp) {
                Arrays.fill(row, -1);
            }
        return fn(nums, n-1,target, dp) == 1;
    }

    int fn(int[] nums, int i, int target, int dp[][]) {
        if(target==0) return 1;
        if(i<0) return 0;
        if (dp[i][target] != -1)
            return dp[i][target];
         int take = 0;
         int not_take = fn(nums,i-1,target,dp);
         if(target-nums[i]>=0) 
         take = fn(nums,i-1,target-nums[i],dp);
         dp[i][target] = take | not_take;
         return dp[i][target];
    }
}