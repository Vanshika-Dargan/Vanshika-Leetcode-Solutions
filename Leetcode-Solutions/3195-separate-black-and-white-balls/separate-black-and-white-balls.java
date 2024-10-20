class Solution {
    public long minimumSteps(String s) {
       
       int count0=0;
       int count1=0;
       for(int i=0;i<s.length();i++){
       char ch=s.charAt(i);
       if(ch=='0') count0++;
       else count1++;
       }
       int last=0;
       long swaps=0;
       for(int i=0;i<s.length();i++){
        char ch = s.charAt(i);
        if(ch =='0'){
        swaps+=i-last;
        last++;
        }
       }
       return swaps;
    }
}