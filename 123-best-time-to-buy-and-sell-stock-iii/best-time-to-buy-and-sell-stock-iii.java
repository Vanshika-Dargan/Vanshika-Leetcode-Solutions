class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n][2][3];
        for(int box[][]:dp){
            for(int row[]:box){
                Arrays.fill(row,-1);
            }
        }
        return fn(prices,0,1,0,dp);
    }

    int fn(int[] prices, int i, int buy,int t,int dp[][][]){

        if(t==2 || i==prices.length){
            return 0;
        }
        if(dp[i][buy][t]!=-1) return dp[i][buy][t];
        int a = fn(prices,i+1,buy,t,dp);
        int b = 0;
        if(buy==0){
            b = fn(prices,i+1,1,t+1,dp) + prices[i];
        }
        else{
            b = fn(prices,i+1,0,t,dp) - prices[i];
        }
        dp[i][buy][t] =  Math.max(a,b);
        return dp[i][buy][t];
    }
}