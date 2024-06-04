class Solution {
    public int longestPalindrome(String s) {
       int freq[]=new int[52];
       for(int i=0;i<s.length();i++){
        if(Character.isUpperCase(s.charAt(i))){
            freq[s.charAt(i)-'A']+=1;
        }
        else{
          freq[s.charAt(i)-'a'+26]+=1;
        }
       }
       boolean single=true;
       int res=0;
       for(int i=0;i<freq.length;i++){
            if(freq[i]%2==0){
                res+=freq[i];
            }
            else{
                if(single){
                    res+=1;
                    single=false;
                }
                res+=freq[i]-1;
            }
       }
       return res; 
    }
}