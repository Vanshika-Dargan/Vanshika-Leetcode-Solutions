class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> set=new HashSet<>();
        int ans=0;
        for(int i=0;i<s.length();i++){
            set.add(s.charAt(i));
        }
        for(char ch:set){
            int first=-1;
            int last=-1;
            Set<Character> unique=new HashSet<>();
            for(int i=0;i<s.length();i++){
            if(ch==s.charAt(i)){
                if(first==-1){
                    first=i;
                }
                last=i;
            }
            }
            for(int i=first+1;i<last;i++){
                unique.add(s.charAt(i));
            }
            ans+=unique.size();
        }
        return ans;
    }
}