class Solution {
    long mod=(long)1e9+7;
    public int countGoodStrings(int low, int high, int zero, int one) {
        
        int dp[] = new int[high+1];
        Arrays.fill(dp,-1);
        return helper(0, low, high, zero, one,dp);
    }

    int helper(int len, int low, int high, int zero, int one,int dp[]) {
       
        if (len > high) {
            return 0;
        }
        
        if(dp[len]!=-1){
            return dp[len];
        }
       
        long count = (len >= low && len <= high) ? 1 : 0;

        
        count += helper(len + zero, low, high, zero, one,dp); 
        count += helper(len + one, low, high, zero, one,dp);  
        dp[len]=(int)(count%mod);
        return dp[len];
    }
}
