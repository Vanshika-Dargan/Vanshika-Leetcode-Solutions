class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[] = new int[amount + 1];

        dp[0] = 0;
        for (int j = 1; j <= amount; j++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < coins.length; i++) {
                int temp = Integer.MAX_VALUE;
                if (j >= coins[i])
                    temp = dp[j - coins[i]];
                if (temp != Integer.MAX_VALUE)
                    min = Math.min(temp + 1, min);
                dp[j] = min;
            }
        }
        int ans = dp[amount];

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int fn(int[] coins, int amount, int dp[]) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        if (dp[amount] != -1)
            return dp[amount];
        for (int i = 0; i < coins.length; i++) {

            int temp = fn(coins, amount - coins[i], dp);
            if (temp != Integer.MAX_VALUE)
                min = Math.min(temp + 1, min);
            dp[amount] = min;
        }
        return min;
    }
}