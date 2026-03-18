class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                char c1 = str1.charAt(i-1);
                char c2 = str2.charAt(j-1);
                if(c1==c2){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        String ans = "";
        int i=n;
        int j=m;
            while(i>0 && j>0){
                char c1 = str1.charAt(i-1);
                char c2 = str2.charAt(j-1);

                if(c1==c2){
                    ans+=c1;
                    i--;
                    j--;
                }
                else{
                    if(dp[i-1][j]>=dp[i][j-1]){
                        ans+=c1;
                        i--;
                    }
                    else{
                        ans+=c2;
                        j--;
                    }
                }

            }
            while(i>0){
                ans+=str1.charAt(i-1);
                i--;
            }
            while(j>0){
                  ans+=str2.charAt(j-1);
                  j--;
            }
            String rev = "";
            for(i=ans.length()-1;i>=0;i--){
                rev+=ans.charAt(i);
            }
            return rev;
        }
    }