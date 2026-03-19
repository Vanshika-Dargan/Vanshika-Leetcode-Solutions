class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int dp[][] = new int[n][m];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
         return fn(s,p,n-1,m-1,dp)==1;
       
    }


    int fn(String s, String p, int i, int j,int dp[][]){
        if(i<0 && j<0) return 1;
        if(j<0) return 0;
        if(i<0){
            for(int k=0;k<=j;k++){
                if(p.charAt(k)!='*') return 0;
            }
            return 1;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        char c1 = s.charAt(i);
        char c2 = p.charAt(j);

        if(c1==c2 || c2=='?'){
            dp[i][j] =fn(s,p,i-1,j-1,dp);
        }
        else if(c2=='*'){
             dp[i][j]= fn(s,p,i-1,j,dp) | fn(s,p,i,j-1,dp);
        }
        else{
             dp[i][j]= 0;
        }
        return dp[i][j];
    }

}