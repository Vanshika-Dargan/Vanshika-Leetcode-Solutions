class Solution {
    public int appendCharacters(String s, String t) {
        
        int i=0; int j=0;
        int m=s.length();
        int n=t.length();

        while(i<m && j<n){

          char inS=s.charAt(i);
          char inT=t.charAt(j);

          if(inS==inT){
            i++;
            j++;
          } 
          else{
            i++;
          } 
        }

        if(i==m && j<n){
            return n-j;
        }
            return 0;
    }
}