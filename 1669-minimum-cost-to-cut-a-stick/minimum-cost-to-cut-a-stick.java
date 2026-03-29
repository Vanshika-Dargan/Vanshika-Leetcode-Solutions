class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        int newCuts[] = new int[m+2];
        int dp[][]=new int[m+2][m+2];
        newCuts[0]=0;
        newCuts[m+1]=n;
        for(int i=0;i<m;i++){
            newCuts[i+1]=cuts[i];
        }

        for(int i=m;i>=1;i--){
            for(int j=i;j<=m;j++){
                int min = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cost = newCuts[j+1]-newCuts[i-1] + dp[i][k-1] + dp[k+1][j];
            min = Math.min(cost,min);
        }
        dp[i][j]= min;
            }
        }

        return dp[1][m];
    }

    int fn(int cuts[],int i, int j,int dp[][]){
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cost = cuts[j+1]-cuts[i-1] + fn(cuts,i,k-1,dp) + fn(cuts,k+1,j,dp);
            min = Math.min(cost,min);
        }
        dp[i][j]= min;
        return dp[i][j];
    }
}