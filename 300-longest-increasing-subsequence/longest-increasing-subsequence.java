class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        
        for(int i=n-1;i>=0;i--){
            for(int prev=0;prev<=n;prev++){
                int not_take = dp[i+1][prev];
        int take = 0;
        if(prev==0 || nums[i]>nums[prev-1]){
            take = 1 + dp[i+1][i+1];
        }

         dp[i][prev] = Math.max(take,not_take);
            }
        }
        return dp[0][0];
    }

    int fn(int[] nums,int i,int prev,int[][] dp){

        if(i==nums.length){
            return 0;
        }
        if(dp[i][prev]!=-1) return dp[i][prev];
        int not_take = fn(nums,i+1,prev,dp);
        int take = 0;
        if(prev==0 || nums[i]>nums[prev-1]){
            take = 1 + fn(nums,i+1,i+1,dp);
        }

         dp[i][prev] = Math.max(take,not_take);
         return dp[i][prev];
    }
}