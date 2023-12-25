class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        int dp[]=new int[n+1];
        dp[n]=1;
        for(int idx=n-1;idx>=0;idx--){
        char curr=s.charAt(idx);
        if(curr!='0'){
        dp[idx]=dp[idx+1];
        if(idx+1<n){
        char next=s.charAt(idx+1);
        if(curr=='1' || (curr=='2' && next>='0' && next<='6'))
        dp[idx]+=dp[idx+2];
        }
        }
        }
        return dp[0];
    }
}