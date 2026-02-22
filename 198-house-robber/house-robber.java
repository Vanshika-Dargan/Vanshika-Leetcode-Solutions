class Solution {
    public int rob(int[] arr) {
         int dp[]=new int[arr.length+1];
        Arrays.fill(dp,-1);
        dp[arr.length]=0;
        for(int i=arr.length-1;i>=0;i--){
            int take = arr[i];
            int not_take = 0;
            if(i+2<=arr.length)
            take += dp[i+2];
            not_take = dp[i+1];
            dp[i]=Math.max(take,not_take);
        }
        return dp[0];
    }
}