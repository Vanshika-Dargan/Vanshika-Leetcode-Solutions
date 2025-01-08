class Solution {
    public int countPrefixSuffixPairs(String[] words) {
       int count=0;
       for(int i=0;i<words.length;i++){
        for(int j=i+1;j<words.length;j++){
            if(words[i].length()>words[j].length()) continue;
            if(isPrefix(words[i],words[j]) && isSuffix(words[i],words[j])) count++;
        }
       }
       return count;
    }

    boolean isPrefix(String pre,String main){
    for(int i=0;i<pre.length();i++){
        if(main.charAt(i)!=pre.charAt(i)){
        return false;
        }
    }
    return true;
    }
        boolean isSuffix(String suf,String main){
            int n=main.length();
            int m=suf.length();
    for(int i=0;i<suf.length();i++){
        if(main.charAt(n-i-1)!=suf.charAt(m-i-1)){
        return false;
        }
    }
    return true;
    }
}