class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // Initialize dp array to store the minimum cost for each state
        int[][] dp = new int[days.length][366];
        for (int i = 0; i < days.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // Call the recursive function and return the result
        return calculateMinCost(days, costs, 0, 0, dp);
    }

    private int calculateMinCost(int[] days, int[] costs, int index, int maxDate, int[][] dp) {
        // Base case: if we've processed all days, return 0 cost
        if (index == days.length) {
            return 0;
        }

        // If already computed, return the stored value
        if (dp[index][maxDate] != Integer.MAX_VALUE) {
            return dp[index][maxDate];
        }

        int currentDay = days[index];
        int ans = Integer.MAX_VALUE;

        // Case 1: Skip buying a new ticket if the current day is covered
        if (maxDate >= currentDay) {
            ans = calculateMinCost(days, costs, index + 1, maxDate, dp);
        }

        // Case 2: Buy a 1-day ticket
        ans = Math.min(ans, costs[0] + calculateMinCost(days, costs, index + 1, currentDay, dp));

        // Case 3: Buy a 7-day ticket
        ans = Math.min(ans, costs[1] + calculateMinCost(days, costs, index + 1, Math.min(365, currentDay + 6), dp));

        // Case 4: Buy a 30-day ticket
        ans = Math.min(ans, costs[2] + calculateMinCost(days, costs, index + 1, Math.min(365, currentDay + 29), dp));

        // Store the result in dp array
        dp[index][maxDate] = ans;

        return ans;
    }
}
