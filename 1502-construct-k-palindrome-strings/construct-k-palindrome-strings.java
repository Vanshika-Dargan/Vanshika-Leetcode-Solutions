class Solution {
    public boolean canConstruct(String s, int k) {
        int freq[] = new int[26];
        if(s.length()<k) return false;
        for(int i=0;i<s.length();i++){
            int ch = s.charAt(i)-'a';
            freq[ch]+=1;
        }
       int oddCount=0;
        for(int i=0;i<26;i++){
        if(freq[i]%2!=0)oddCount++;
        }
        return oddCount<=k;
    }
}