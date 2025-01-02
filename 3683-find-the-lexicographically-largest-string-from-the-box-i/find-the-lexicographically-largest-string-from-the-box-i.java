class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends==1) return word;
        int desired=word.length()-numFriends+1;
        String max="";
        for(int i=0;i<word.length();i++){
           int limit=i+desired>word.length()?word.length():i+desired;
           String curr=word.substring(i,limit);
           max=curr.compareTo(max)>0?curr:max;
        }
        return max;
         
    }
}