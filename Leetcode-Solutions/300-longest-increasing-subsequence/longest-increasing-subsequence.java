class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        Integer dp[][]=new Integer[n][n+1];
       return helper(nums.length-1,nums,n,dp);
    }

    int helper(int i,int[] nums,int max,Integer[][] dp){
        
        if(i<0){
            return 0;
        }
        if(dp[i][max] !=null){
            return dp[i][max];
        }
        int first=0;
        if(max==nums.length || nums[i]<nums[max] ){
        first=1+helper(i-1,nums,i,dp);
        }
        int second=0+helper(i-1,nums,max,dp);
        dp[i][max]=Math.max(first,second);
        return Math.max(first,second);
    }
}