class Solution {
    public int prefixCount(String[] words, String pref) {
        int count=0;
     for(int i=0;i<words.length;i++){
        if(hasPrefix(words[i],pref)) count++;
     }
     return count;
    }

    boolean hasPrefix(String word,String pre){
        if(word.length()<pre.length()) return false;
        for(int i=0;i<pre.length();i++){
            if(word.charAt(i)!=pre.charAt(i)) return false;
        }
        return true;
    }
}