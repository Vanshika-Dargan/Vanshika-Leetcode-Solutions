class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        
        return fn(coins, n - 1, amount, dp);
    }

    int fn(int[] coins, int i, int amount, int dp[][]) {
        if (i == 0) {
            if (amount % coins[0] == 0)
                return 1;
            return 0;
        }
        if (dp[i][amount] != -1)
            return dp[i][amount];
        int pick = 0;
        int not_pick = fn(coins, i - 1, amount,dp);
        if (amount >= coins[i])
            pick = fn(coins, i, amount - coins[i],dp);
        dp[i][amount] = pick + not_pick;
        return dp[i][amount];
    }
}