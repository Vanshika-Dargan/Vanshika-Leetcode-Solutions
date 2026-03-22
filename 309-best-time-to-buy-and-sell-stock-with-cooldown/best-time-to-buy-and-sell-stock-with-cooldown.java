class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return fn(prices,0,1,dp);
    }
    int fn(int[] prices, int i, int buy,int dp[][]){

        if(i>=prices.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        int a = fn(prices,i+1,buy,dp);
        int b = 0;
        if(buy==0){
            b= fn(prices,i+2,1,dp) + prices[i];
        }
        else{
            b = fn(prices,i+1,0,dp) - prices[i];
        }
        dp[i][buy] =  Math.max(a,b);
        return dp[i][buy];
    }
}