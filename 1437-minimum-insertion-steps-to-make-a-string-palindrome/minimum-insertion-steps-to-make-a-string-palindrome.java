class Solution {
    public int minInsertions(String s) {
         String s1 = s;
        String s2 = "";
         int n = s1.length();
        for(int i=0;i<n;i++){
            s2+=s1.charAt(n-i-1);
        };
        int dp[]=new int[n+1];
      
        
        for(int j=0;j<=n;j++) dp[j]=0;
        
        for(int i=0;i<n;i++){
              int curr[]=new int[n+1];
            for(int j=0;j<n;j++){
               char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        if(c1==c2){
            curr[j+1]=1+dp[j];
        }
        else{
        curr[j+1]=Math.max(curr[j],dp[j+1]);
        } 
            }
            dp = curr;
        }
        
        return n-dp[n];
    }
}