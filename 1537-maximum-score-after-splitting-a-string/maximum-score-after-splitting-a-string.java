class Solution {
    public int maxScore(String s) {
        int ones=0;
        int zeros=0;

        for(int i=0;i<s.length();i++){
            int ch=s.charAt(i)-'0';
            if(ch==1) ones+=1;
        }
       int score=0;
       for(int i=0;i<s.length()-1;i++){
        int ch=s.charAt(i)-'0';
        if(ch==0){
        zeros+=1;
        }
        else{
            ones-=1;
        }
          score=Math.max(score,ones+zeros);
       }
       return score;
    }
}