class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[] = new int[2];

        for (int i = n-1; i >=0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                int a = 0;
                int b = 0;
                a = dp[buy];
                if (buy == 1) {
                    b = dp[0] - prices[i];
                } else if (buy == 0) {
                    b = dp[1] + prices[i];
                }
                dp[buy] = Math.max(b, a);
            }
        }
        return dp[1];
    }

    int fn(int[] prices, int i, int buy, int dp[][]) {

        if (i == prices.length) {
            return 0;
        }
        if (dp[i][buy] != -1)
            return dp[i][buy];
        int a = 0;
        int b = 0;
        a = fn(prices, i + 1, buy, dp);
        if (buy == 1) {
            b = fn(prices, i + 1, 0, dp) - prices[i];
        } else if (buy == 0) {
            b = fn(prices, i + 1, 1, dp) + prices[i];
        }
        dp[i][buy] = Math.max(b, a);
        return dp[i][buy];
    }
}