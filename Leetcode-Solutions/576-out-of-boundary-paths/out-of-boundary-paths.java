class Solution {
    int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
    int mod=(int)1e9+7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer dp[][][]=new Integer[51][51][51];
        return helper(m,n,maxMove,startRow,startColumn,0,dp);
    }

    int helper(int m,int n,int maxMove,int startRow,int startColumn,int curr,Integer dp[][][]){
    
    if((startRow==-1 || startRow==m || startColumn==-1 || startColumn==n) && curr<=maxMove){
        
        return 1;
    }
    if(curr>maxMove){
        return 0;
    }
    if(dp[startRow][startColumn][curr]!=null){
        return dp[startRow][startColumn][curr];
    }
    int ans=0;
    for(int d[]:dir){
        int nextRow=d[0]+startRow;
        int nextColumn=d[1]+startColumn;
        ans=(ans+helper(m,n,maxMove,nextRow,nextColumn,curr+1,dp))%mod;
    }
    dp[startRow][startColumn][curr]=ans;
    return ans;
    }
}