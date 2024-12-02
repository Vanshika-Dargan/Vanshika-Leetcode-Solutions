class Solution {
    public int isPrefixOfWord(String s, String searchWord) {
        
       String[] words = s.split(" ");
       
       for(int i=0;i<words.length;i++){
        if(words[i].startsWith(searchWord)) return i+1;
       }
       return -1;
    }
}