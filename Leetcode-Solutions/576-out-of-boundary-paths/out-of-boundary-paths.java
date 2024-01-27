class Solution {
    int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
    int mod=(int)1e9+7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int dp[][][]=new int[2][51][51];
        for(int curr=1;curr<=maxMove;curr++){
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    int ans=0;
                    for(int d[]:dir){
                    
              int nextRow=d[0]+i;
              int nextColumn=d[1]+j;
              if((nextRow==-1 ||  nextRow==m ||   nextColumn==-1 ||  nextColumn==n))
              ans++;
              else
              ans=(ans+dp[(curr-1)&1][nextRow][nextColumn])%mod;
    }
    dp[curr&1][i][j]=ans;
                }
            }
        }
        return dp[maxMove&1][startRow][startColumn];
        
    }

}