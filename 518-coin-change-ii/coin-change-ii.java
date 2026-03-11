class Solution {
    public int change(int A, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][A + 1];
        
        for(int amount=0;amount<=A;amount++){
        if (amount % coins[0] == 0) {
            dp[0][amount] = 1;
        } else
            dp[0][amount] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int amount = 0; amount <= A; amount++) {
                int pick = 0;
                int not_pick = dp[i - 1][amount];
                if (amount >= coins[i])
                    pick = dp[i][amount - coins[i]];
                dp[i][amount] = pick + not_pick;
            }
        }

        return dp[n - 1][A];
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
        int not_pick = fn(coins, i - 1, amount, dp);
        if (amount >= coins[i])
            pick = fn(coins, i, amount - coins[i], dp);
        dp[i][amount] = pick + not_pick;
        return dp[i][amount];
    }
}