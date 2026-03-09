class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[] = new int[amount+1];
        
            Arrays.fill(dp,-1);

        int ans = fn(coins,amount,dp);

        return ans==Integer.MAX_VALUE?-1:ans;
    }

    int fn(int[] coins,int amount,int dp[]){
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
         if(dp[amount]!=-1) return dp[amount];
        for(int i=0;i<coins.length;i++){
            
            int temp = fn(coins,amount-coins[i],dp);
            if(temp!=Integer.MAX_VALUE)
            min = Math.min(temp+1,min);
            dp[amount] = min;
        }
        return min;
    }
}