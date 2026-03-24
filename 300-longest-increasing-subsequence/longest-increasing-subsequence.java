class Solution {
    public int lengthOfLIS(int[] arr) {
       int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j]<arr[i])
                dp[i]=Math.max(dp[i],1+dp[j]);
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }

    int fn(int[] nums, int i, int prev, int[][] dp) {

        if (i == nums.length) {
            return 0;
        }
        if (dp[i][prev] != -1)
            return dp[i][prev];
        int not_take = fn(nums, i + 1, prev, dp);
        int take = 0;
        if (prev == 0 || nums[i] > nums[prev - 1]) {
            take = 1 + fn(nums, i + 1, i + 1, dp);
        }

        dp[i][prev] = Math.max(take, not_take);
        return dp[i][prev];
    }
}