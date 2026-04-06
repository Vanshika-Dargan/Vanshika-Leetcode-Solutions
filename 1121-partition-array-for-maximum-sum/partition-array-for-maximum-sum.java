class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return fn(arr,k,0,dp);
    }

    int fn(int[] arr,int k, int i,int[] dp){
        if(i==arr.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int max = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for(int j=i;j<Math.min(arr.length,i+k);j++){
            max = Math.max(max,arr[j]);
            maxSum = Math.max(maxSum,max*(j-i+1) + fn(arr,k,j+1,dp));
        }
        dp[i]= maxSum;
        return dp[i];
    }
}