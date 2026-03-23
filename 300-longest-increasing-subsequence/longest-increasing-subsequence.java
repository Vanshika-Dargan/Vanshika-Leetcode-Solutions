class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return fn(nums,0,-1,dp);
    }

    int fn(int[] nums,int i,int prev,int[][] dp){

        if(i==nums.length){
            return 0;
        }
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int not_take = fn(nums,i+1,prev,dp);
        int take = 0;
        if(prev==-1 || nums[i]>nums[prev]){
            take = 1 + fn(nums,i+1,i,dp);
        }

         dp[i][prev+1] = Math.max(take,not_take);
         return dp[i][prev+1];
    }
}