class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        int newCuts[] = new int[m+2];
        int dp[][]=new int[m+1][m+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        newCuts[0]=0;
        newCuts[m+1]=n;
        for(int i=0;i<m;i++){
            newCuts[i+1]=cuts[i];
        }
        return fn(newCuts,1,m,dp);
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