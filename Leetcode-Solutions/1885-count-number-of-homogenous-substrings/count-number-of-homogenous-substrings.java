class Solution {
    public int countHomogenous(String s) {
        int j=0;
        long n=0;
        long res=0;
        int mod=(int)1e9+7;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==s.charAt(j)){
                n++;
            }
            else{
                res+=((n)*(n+1))/2;
                res%=mod;
                n=1;
                j=i;
            }
        }
        res+=((n)*(n+1))/2;
        res%=mod;
        return (int)res;
    }
}